<template>
    <div class="main">
        <!-- 상단 검색 부분 -->
        <v-card 
            id="create"
            flat
        >

            <v-autocomplete
              :items="components"
              @change="getSelectedAppName">

            </v-autocomplete>

            <!-- 바로가기 아이콘들이 들어가는 곳 -->
            <v-card-text style="height:75vh" class="grey lighten-5">

            
            </v-card-text>

            <!-- 우측 하단 플로팅 버튼 생기는 곳 -->
            <v-speed-dial
                bottom
                right
                transition="slide-y-reverse-transition"
            >
                <template v-slot:activator>
                <v-btn
                    dark
                    color="pink"
                >
                <v-icon>reorder</v-icon>
                </v-btn>
                </template>
                <!-- <v-btn
                    fab
                    dark
                    small
                    color="green"
                >
                <v-icon>mdi-pencil</v-icon>
                </v-btn> -->

                <!-- 플로팅 버튼 클릭 시 나타나는 리스트카드 -->
                <v-card
                    class="shortList"
                    max-width="500"
                >
                    <v-list>
                    <v-list-item-group v-model="model">
                        <v-list-item
                        v-for="(item, i) in items"
                        :key="i"
                        >
                        <v-list-item-icon>
                            <v-icon v-text="item.icon"></v-icon>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <router-link :to="item.router">
                            <v-list-item-title v-text="item.text"></v-list-item-title>
                            </router-link>
                        </v-list-item-content>
                        </v-list-item>
                    </v-list-item-group>
                    </v-list>
                </v-card>
            </v-speed-dial>
        </v-card>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    //페이지가 호출될때 바로 실행되는 함수. created -> mounted -> updated -> destroyed
    created(){
      axios.get('/main')
            .then((response) => {
              alert("OK : "+response.data);
              //this.components = response.data;
              for(var i = 0;i < response.data.length;i++){
                this.components.push(response.data[i].name);
              }
            }).catch((ex)=> {
              alert("ERROR!!!! : "+ex);
              console.warn("ERROR!!!! : ", ex);
            })
    },
    data: () => ({
      items: [
        {
          icon: 'person',
          text: '로그인',
          router: '/login',
        },
        {
          icon: 'question_answer',
          text: '등록',
          router: '/register',
        },
        {
          icon: 'keyboard_arrow_down',
          text: '카테고리',
          router: '/category',
        },
        {
          icon: 'keyboard_arrow_down',
          text: '문의',
          router: '/qna',
        },        
      ],
      //components:['Autocompletes', 'Comboboxes', 'Forms', 'Inputs', 'Overflow Buttons', 'Selects', 'Selection Controls', 'Sliders', 'Textareas', 'Text Fields',],
      components: [],
      model: 1,
    }),
    methods: {
        getSelectedAppName : function(appName){
            alert(appName);
            //this.$router.push('/searchList');
            this.$router.push({path: '/searchList', param: {name: appName}});
        },
    },
}
</script>

<style scoped>
#create .v-speed-dial {
  position: absolute;
}
#create .v-btn--floating {
  position: relative;
}
#create .shortList {
    right: 30px;
}
</style>