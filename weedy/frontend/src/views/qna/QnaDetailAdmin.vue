<template>
<v-app>
    <v-row>
        <v-col cols="12" md="4"/>
        <v-col cols="12" md="4">
            <v-form
            ref="form"
            v-model="valid"

            >
                <v-text-field
                    v-model="title"
                    label="제목"
                    disabled
                    required
                ></v-text-field>
                <v-text-field
                    v-model="userId"
                    label="작성자"
                    disabled
                    required
                ></v-text-field>
                <v-textarea
                    disabled
                    outlined
                    name="input-7-4"
                    label="내용"
                    placeholder="내용을 적어주세요."
                ></v-textarea>
                <v-row>
                    <v-col cols="12" md="4">
                    <v-file-input disabled small-chips accept="image/*" label="첨부파일"></v-file-input>
                    </v-col>
                </v-row>
                <v-container fluid>
                    <v-checkbox disabled v-model="checkbox" :label="`비밀글`"></v-checkbox>
                </v-container>
            </v-form>
        </v-col>
        <v-col cols="12" md="4"/>
    </v-row>
        <v-row>
            <v-col cols="12" md="2"/>
            <v-col cols="12" md="8">
                                <!-- 관리자 댓글 폼-->
                <template>
                    <v-card
                        color="red lighten-2"
                        dark
                    >
                        <v-card-title class="headline red lighten-3">
                            <v-icon>mdi-account</v-icon>
                        관리자 댓글
                        </v-card-title>
                        <tr></tr>
                        <v-card-text>
                            <v-textarea
                                outlined
                                name="input-7-4"
                                placeholder="댓글을 남겨주세요."
                            ></v-textarea>
                        </v-card-text>
                        <div class="text-right">
                            <v-btn large class="ma-2" color="error" @click="del">삭제</v-btn>
                            <v-btn large class="ma-2" color="warning" @click="modify">수정</v-btn>
                            <v-btn large class="ma-2" color="success" @click="register">등록</v-btn>
                        </div>
                    </v-card>
                    </template>
            </v-col>
            <v-col cols="12" md="2"/>
        </v-row>
</v-app>
</template>

<script>
  export default {
    data: () => ({
        valid:'',
        title: '',
        userId: '',
        checkbox: false
    }),
    methods: {
        del(){

        },
        modify(){

        },
        register(){
            
        }
    }
  }
</script>