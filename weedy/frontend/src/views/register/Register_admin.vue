<template>
<v-app>
  <v-card>
    <v-toolbar>
      <template>
        <v-row>
          <v-col cols="12" md="2"/>
          <v-col cols="12" md="8">
            <v-tabs
              color="black"
              slider-color="#BDBDBD" 
              grow
              background-color="#F5F5F5"
              v-model="currentItem"
            >
              <v-tab
                v-for="item in items"
                :key="item"
                :href="'#tab-' + item"
              >
                {{ item }}
              </v-tab>
            </v-tabs>
          </v-col>
          <v-col cols="12" md="2"/>
        </v-row>
      </template>
    </v-toolbar>

    <v-tabs-items v-model="currentItem">
      <v-tab-item
        v-for="item in items"
        :key="item"
        :value="'tab-' + item"
      >
        <v-card flat>
          <v-card-text
           v-if="item == '등록'">
             <!--등록 레이아웃 -->
              <v-row>
                  <v-col cols="12" md="4"/>
                  <v-col cols="12" md="4">
                      <v-form
                      ref="form"
                      v-model="valid"
                      :lazy-validation="lazy"
                      >
                          <v-text-field
                              v-model="title"
                              :rules="titleRules"
                              label="제목"
                              required
                          ></v-text-field>
                          <v-text-field
                              v-model="app"
                              :rules="appRules"
                              label="앱이름"
                              required
                          ></v-text-field>
                          <v-text-field
                              v-model="url"
                              label="url"
                              required
                          ></v-text-field>
                          <v-text-field
                              v-model="short_description"
                              label="한줄요약"
                              required
                          ></v-text-field>
                          <v-row>
                              <v-col cols="12" md="4">
                              <v-file-input small-chips accept="image/*" label="메인이미지"></v-file-input>
                              </v-col>
                          </v-row>
                          <v-file-input small-chips accept="image/*" label="아이콘"></v-file-input>
                          <v-textarea
                          outlined
                          name="input-7-4"
                          label="설명"
                          value="어플에 대한 설명을 적어주세요."
                          ></v-textarea>
                          <v-textarea
                          outlined
                          name="input-7-4"
                          label="새로운 기능"
                          value="새로운 기능을 적어주세요."
                          ></v-textarea>
                          <h3>
                              정보
                          </h3>
                          <v-row>
                              <v-col cols="12" md="2"/>
                              <v-col cols="12" md="10">
                                  <v-text-field
                                  v-model="company"
                                  label="개발사"
                                  required
                                  ></v-text-field>
                              </v-col>
                          </v-row>
                          <v-row>
                              <v-col cols="12" md="2"/>
                              <v-col cols="12" md="10">
                                  <v-select
                              :items="category"
                              label="카테고리"
                              ></v-select>
                              </v-col>
                          </v-row>
                          <v-row>
                              <v-col cols="12" md="2"/>
                              <v-col cols="12" md="10">
                                  <v-text-field
                                  v-model="language"
                                  label="언어"
                                  required
                                  ></v-text-field>
                              </v-col>
                          </v-row>
                          <v-row>
                              <v-col cols="12" md="2"/>
                              <v-col cols="12" md="10">
                                  <v-text-field
                                  v-model="age"
                                  label="연령"
                                  required
                                  ></v-text-field>
                              </v-col>
                          </v-row>
                          <v-row>
                              <v-col cols="12" md="2"/>
                              <v-col cols="12" md="10">
                                  <v-text-field
                                  v-model="copyright"
                                  label="저작권"
                                  required
                                  ></v-text-field>
                              </v-col>
                          </v-row>
                          <v-row>
                              <v-col cols="12" md="2"/>
                              <v-col cols="12" md="10">
                                  <v-text-field
                                  v-model="private_info_policy"
                                  label="개인정보"
                                  required
                                  ></v-text-field>
                              </v-col>
                          </v-row>
                          <div class="text-right">
                          <v-btn large class="ma-2" @click="cancel">취소</v-btn>
                          <v-btn large class="ma-2" color="success" @click="register">등록</v-btn>
                          </div>
                          
                      </v-form>
                  </v-col>
                  <v-col cols="12" md="4"/>
              </v-row>
            <!-- -->
          </v-card-text>
           <v-card-text
           v-if="item == '현황'">
            <!--현황 레이아웃 -->
            <v-row>
              <v-col cols="12" md="2"/>
              <v-col cols="12" md="8">
                  <div>
                      <v-data-table
                      :headers="headers"
                      :items="desserts"
                      :options.sync="options"
                      :server-items-length="totalDesserts"
                      :loading="loading"
                      class="elevation-1"
                      ></v-data-table>
                  </div>
              </v-col>
              <v-col cols="12" md="2"/>
            </v-row>
              <!-- -->
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</v-app>
</template>


<script>
  export default {
    data: () => ({
      currentItem: 'tab-등록',
      items: [
        '등록', '현황'
      ],
      totalDesserts: 0,
      desserts: [],
      loading: true,
      options: {},
      headers: [
        {
        text: '번호',
        align: 'left',
        value: 'no',
        },
        { text: '앱이름', value: 'app' },
        { text: '제목', value: 'title' },
        { text: '등록자', value: 'register' },
        { text: '날짜', value: 'date' },
        { text: '처리여부', value: 'bool' },
      ],
      valid: true,
      title: '',
      titleRules: [
        v => !!v || 'Title is required',
      ],
      app: '',
      appRules: [
        v => !!v || 'App Name is required',
        v => /.+@.+\..+/.test(v) || 'App Name must be valid',
      ],
      url:'',
      short_description:'',
      company:'',
      language:'',
      age:'',
      copyright:'',
      private_info_policy:'',
      imageRules:[
          
      ],
      category: ['1', '2', '3', '4'],
      select: null,
      checkbox: false,
      lazy: false
    }),
     methods: {
      getDataFromApi () {
        this.loading = true
        return new Promise((resolve, reject) => {
          const { sortBy, descending, page, itemsPerPage } = this.options
          let items = this.getDesserts()
          const total = items.length
          if (this.options.sortBy) {
            items = items.sort((a, b) => {
              const sortA = a[sortBy]
              const sortB = b[sortBy]
              if (descending) {
                if (sortA < sortB) return 1
                if (sortA > sortB) return -1
                return 0
              } else {
                if (sortA < sortB) return -1
                if (sortA > sortB) return 1
                return 0
              }
            })
          }
          if (itemsPerPage > 0) {
            items = items.slice((page - 1) * itemsPerPage, page * itemsPerPage)
          }
          setTimeout(() => {
            this.loading = false
            resolve({
              items,
              total,
            })
          }, 1000)
        })
      },
      getDesserts () {
        return [
          {
            no: '1',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
          {
            no: '2',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
          {
            no: '3',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
          {
            no: '4',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
          {
            no: '5',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
          {
            no: '6',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
          {
            no: '7',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
          {
            no: '8',
            app: 'app',
            title: '등록을 신청합니다.',
            register: '전예림',
            date: '2019.09.09',
            bool: 'Y',
          },
        ]
      },
      validate () {
        if (this.$refs.form.validate()) {
          this.snackbar = true
        }
      },
      register(){
        // insert
        app.post('/register_admin', function (req, res) {
          var apps = {
            'userid': req.body.userid,
            'name': req.body.name,
            'address': req.body.address
          };
          var query = connection.query('insert into apps set ?', apps, function (err, result) {
            if (err) {
              console.error(err);
              throw err;
            }
            res.status(200).send('success');
          });
        });
      },
      cancel(){

      },
    },

    watch: {
      options: {
        handler () {
          this.getDataFromApi()
            .then(data => {
              this.desserts = data.items
              this.totalDesserts = data.total
            })
        },
        deep: true,
      },
    },
    mounted () {
      this.getDataFromApi()
        .then(data => {
          this.desserts = data.items
          this.totalDesserts = data.total
        })
    }
  }
</script>