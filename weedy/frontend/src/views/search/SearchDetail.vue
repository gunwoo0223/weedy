<template>
  <v-app id="inspire">
    <v-content>
      <v-container
        class="fill-height"
        fluid
      >
        <v-row
          align="center"
          justify="center"
        >
          <v-col
            cols="6"
          >
            <v-card
              height="100%">
              <div class="d-flex">
                  <v-avatar
                      class="ma-3"
                      size="150"
                      tile
                  >
                  <!-- <v-img :src="card.src"></v-img> -->
                  <v-img :src="require('@/images/small_icon/dog.jpg')"></v-img>
                  </v-avatar>
                  <v-card-text>
                      <div class="display-1 text--primary">
                        {{name}}
                      </div>
                      <div>
                          <a v-bind:href="url" target="_blank">{{url}}</a>
                      </div>
                      <div>
                          {{shortDescription}}
                      </div>
                      <div>
                          별점
                      </div>
                  </v-card-text>
              </div>
              <div>
                <v-divider></v-divider>
                <v-card-text>
                  <v-card-actions>
                    <div><b>어플설명</b></div><br>
                    <v-spacer></v-spacer>
                    <v-btn
                      icon
                      @click="descriptionShow = !descriptionShow"
                    >
                      <v-icon>{{ descriptionShow ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                    </v-btn>
                  </v-card-actions>
                  <v-expand-transition>
                    <div v-show="descriptionShow">
                      <v-card-text>
                        <div class="description" v-html="description"></div>
                      </v-card-text>
                    </div>
                  </v-expand-transition>
                </v-card-text>
              </div>
              <div>
                <v-divider></v-divider>
                <v-card-text>
                  <v-card-actions>
                    <div><b>새로운 기능</b></div>
                    <v-spacer></v-spacer>
                    <v-btn
                      icon
                      @click="versionHistory = !versionHistory"
                    >
                      <v-icon>{{ versionHistory ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                    </v-btn>
                  </v-card-actions>
                  <v-expand-transition>
                    <div v-show="versionHistory">
                      <v-card-text>
                        새로운 기능 contents
                      </v-card-text>
                    </div>
                  </v-expand-transition>
                </v-card-text>
              </div>
              <div>
                <v-divider></v-divider>
                <v-card-text>
                  <v-card-actions>
                    <div><b>정보</b></div><br>
                    <v-spacer></v-spacer>
                    <v-btn
                      icon
                      @click="appInfo = !appInfo"
                    >
                      <v-icon>{{ appInfo ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                    </v-btn>
                  </v-card-actions>
                <v-expand-transition>
                    <div v-show="appInfo">
                      <v-card-text>
                        <table>
                          <tr>
                            <td><b>개발사</b></td>
                            <td>&nbsp;&nbsp;{{company}}</td>
                          </tr>
                          <tr>
                            <td><b>카테고리</b></td>
                            <td>&nbsp;&nbsp;{{category}}</td>
                          </tr>
                          <tr>
                            <td><b>언어</b></td>
                            <td>&nbsp;&nbsp;{{language}}</td>
                          </tr>
                          <tr>
                            <td><b>연령</b></td>
                            <td>&nbsp;&nbsp;{{age}}+</td>
                          </tr>
                          <tr>
                            <td><b>저작권</b></td>
                            <td>&nbsp;&nbsp;{{copyright}}</td>
                          </tr>
                          <tr>
                            <td><b>개인정보 취급방침</b></td>
                            <td>&nbsp;&nbsp;<a v-bind:href="privateInfoPolicy" target="_blank">서비스 약관 보러가기</a></td>
                          </tr>
                        </table>
                      </v-card-text>
                    </div>
                </v-expand-transition>
                </v-card-text>
              </div>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import Axios from 'axios'
export default {
    data: () => ({
      descriptionShow: true,
      versionHistory: true,
      appInfo: true,
      name: '', 
      url: '', 
      shortDescription: '', 
      description: '', 
      company: '', 
      category: '', 
      language: '', 
      age: '', 
      copyright: '', 
      privateInfoPolicy: '',
  }),
  created(){
    Axios.get('/searchDetail/'+this.$route.params.id)
        .then((response)=>{
          alert("searchDetail server Access SUCCESS!!");
          this.name = response.data.name;
          this.url = response.data.url;
          this.shortDescription = response.data.shortDescription;
          this.description = response.data.description;
          this.company = response.data.company;
          this.category = response.data.category;
          this.language = response.data.language;
          this.age = response.data.age;
          this.copyright = response.data.copyright;
          this.privateInfoPolicy = response.data.privateInfoPolicy;
        })
        .catch((ex)=>{
          console.log(ex);
          alert("searchDetail server Access ERROR!!");
        })
  },

}
</script>

<style scoped>
  .description{
    white-space: pre-line;
  }
</style>