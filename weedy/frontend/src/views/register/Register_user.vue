<template>
    <v-container>
        <v-app>
            <v-row
                class="mb-12"
                justify="center"
                no-gutter
            >
                <v-col lg="1"/>
                <v-col lg="10">
                    <v-card>
                        <v-tabs
                        v-model="tab"
                        background-color="deep-purple accent-4"
                        centered
                        dark
                        icons-and-text
                        >
                        <v-tab to="/foo">Foo</v-tab>
                        <v-tab to="/bar">Bar</v-tab>    
                        <!--
                        <v-tab href="#tab-1">
                            등록
                            <v-icon></v-icon>
                        </v-tab>

                        <v-tab href="#tab-2">
                            현황
                            <v-icon></v-icon>
                        </v-tab>
                        </v-tabs>
                        -->

                        <!--
                        <v-tabs-items v-model="tab">
                        <v-tab-item
                            v-for="i in 3"
                            :key="i"
                            :value="'tab-' + i"
                        >
                            <v-card flat>
                            <v-card-text>{{ text }}</v-card-text>
                            </v-card>
                        </v-tab-item>
                        </v-tabs-items>
                        -->
                        </v-tabs>
                        <router-view></router-view>
                    </v-card>
                </v-col>
                <v-col lg="1"/>
            </v-row>
        </v-app>
    </v-container>
</template>



<script>
import VueRouter from 'vue-router';

  export default {
    data () {
      return {
        tab: null,
        text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.'      
      }
    },
    computed: {
    username () {
      // 곧 `params` 확인할 수 있습니다.
      return this.$route.params.username
    }
  },
  methods: {
    goBack () {
      window.history.length > 1
        ? this.$router.go(-1)
        : this.$router.push('/')
    }
  }
  }

const Foo = {
  template: '<div>Foo component!</div>'
};

const Bar = {
  template: '<div>Bar component!</div>'
};

const routes = [
  { path: '/foo', component: Foo },
  { path: '/bar', component: Bar },
];

const router = new VueRouter({ routes });

// new Vue({
//   el: '#app',
//   router,
// });
</script>