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
                          어플명
                      </div>
                      <div class="text--primary">
                          url
                      </div>
                      <div class="text--primary">
                          한줄요약
                      </div>
                      <div class="text--primary">
                          별점
                      </div>
                  </v-card-text>
              </div>
              <div>
                <v-card-text>
                    <div class="text--primary">어플설명</div><br>
                    <div class="text--primary">어플설명contents</div>
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
                    <div class="text--primary">개발사 개발사명</div>
                    <div class="text--primary">카테고리 카테고리</div>
                    <div class="text--primary">언어 언어</div>
                    <div class="text--primary">연령 연령</div>
                    <div class="text--primary">저작권 저작권</div>
                    <div class="text--primary">개인정보 취급방침 개인정보 취급방침</div>
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
export default {
    data: () => ({
      show: false,
  }),
}
</script>

<style scoped>

</style>