<template>
    <div class="searchList">
        <v-app id="searchList">
            <v-card
            width="100%"
            >
        
            <v-container fluid>
                <v-row dense>
                <v-col
                    v-for="card in appListInfo"
                    :key="card.id"
                    :cols="card.flex"
                >
                    <v-card>
                        <div class="d-flex">
                            <v-avatar
                                class="ma-3"
                                size="150"
                                tile
                            >
                            <!-- <v-img :src="card.src"></v-img> -->
                            </v-avatar>
                            <v-card-text>
                                <div class="display-1 text--primary">
                                    {{card.name}}
                                </div>
                                <div class="text--primary">
                                    {{card.url}}
                                </div>
                                <div class="text--primary">
                                    {{card.shortDescription}}
                                </div>
                                <div class="text--primary">
                                    STAR
                                </div>
                            </v-card-text>
                        </div>
                    <!-- <v-card-actions>
                        <v-spacer></v-spacer>
        
                        <v-btn icon>
                        <v-icon>mdi-heart</v-icon>
                        </v-btn>
        
                    </v-card-actions> -->
                    </v-card>
                </v-col>
                </v-row>
            </v-container>
            </v-card>
        </v-app>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    created(){
        axios.get('/searchList/'+this.$route.params.id)
                .then((response) => {
                    alert("searchList Data Access success!!");

                    this.appListInfo.push({id: response.data.id, name:response.data.name, url:response.data.url, shortDescription:response.data.shortDescription,flex:6});

                }).catch((ex) => {
                    alert("searchList Data Access Fail!!"+ ex);
                })
    },
    data: ()=>({
        appListInfo:[],
        // cards: [
        //     { title: 'Pre-fab homes', subtitle:'test1', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg', flex: 6 },
        //     { title: 'Favorite road trips', subtitle:'test2', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg', flex: 6 },
        //     { title: 'Best airlines',  subtitle:'test3', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg', flex: 6 },
        // ]
    }),
}
</script>

<style scoped>

</style>