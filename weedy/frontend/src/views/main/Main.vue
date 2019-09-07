<template>
    <div class="main">
        <!-- 상단 검색 부분 -->
        <v-card
            class="pa-4"
            flat
        >
            <v-toolbar
            dense
            floating
            >
            <v-text-field
                hide-details
                single-line
            ></v-text-field>

            <v-btn icon>
                <v-icon>search</v-icon>
            </v-btn>

            </v-toolbar>
        </v-card>
        <!-- 아이콘들이 들어가는 곳 -->
        <v-card-text style="height:60vh" class="grey lighten-5">

        
        </v-card-text>

        <!-- 우측 하단 버튼 생기는 곳 -->
        <v-card-text style="position: relative">
            <v-fab-transition>
            <v-btn
            absolute
            dark
            fab
            bottom
            right
            color="pink"
            >
            <v-icon>reorder</v-icon>
            </v-btn>
            </v-fab-transition>
        </v-card-text>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>

</style>