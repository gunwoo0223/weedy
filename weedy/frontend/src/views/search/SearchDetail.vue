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
              height="100vh">
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
                      <div class="text--primary">
                          {{url}}
                      </div>
                      <div class="text--primary">
                          한줄요약 {{shortDescription}}
                      </div>
                      <div class="text--primary">
                          별점
                      </div>
                  </v-card-text>
              </div>
              <div>
                <v-card-text>
                    <div class="text--primary">어플설명</div><br>
                    <div class="text--primary">어플설명contents {{description}}</div>
                </v-card-text>
              </div>
              <div>
                <v-card-text>
                    <div class="text--primary">새로운 기능</div><br>
                    <div class="text--primary">새로운 기능 contents</div>
                </v-card-text>
              </div>
              <div>
                <v-card-text>
                    <div class="text--primary">정보</div><br>
                    <div class="text--primary">개발사 개발사명 {{company}}</div>
                    <div class="text--primary">카테고리 카테고리 {{category}}</div>
                    <div class="text--primary">언어 언어 {{language}}</div>
                    <div class="text--primary">연령 연령 {{age}}</div>
                    <div class="text--primary">저작권 저작권 {{copyright}}</div>
                    <div class="text--primary">개인정보 취급방침 개인정보 취급방침 {{privateInfoPolicy}}</div>
                </v-card-text>
              </div>
              <div>
                <v-card-actions>
                  <div class="text--primary">Share</div>
                  <v-spacer></v-spacer>
                  <v-btn
                    icon
                    @click="show = !show"
                  >
                    <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                  </v-btn>
                </v-card-actions>
                <v-expand-transition>
                  <div v-show="show">
                    <v-divider></v-divider>
                    <v-card-text>
                      I'm a thing. But, like most politicians, he promised more than he could deliver. You won't have time for sleeping, soldier, not with all the bed making you'll be doing. Then we'll go with that data file! Hey, you add a one and two zeros to that or we walk! You're going to do his laundry? I've got to find a way to escape.
                    </v-card-text>
                  </div>
                </v-expand-transition>
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
      show: false,
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
          console.log(response);
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
          alert("searchDetail server Access SUCCESS!!");
        })
        .catch((ex)=>{
          console.log(ex);
          alert("searchDetail server Access ERROR!!");
        })
  },

}
</script>

<style scoped>

</style>