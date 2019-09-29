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
                    :rules="titleRules"
                    label="제목"
                    required
                ></v-text-field>
                <v-textarea
                    outlined
                    name="input-7-4"
                    label="내용"
                    placeholder="내용을 적어주세요."
                ></v-textarea>
                <v-row>
                    <v-col cols="12" md="4">
                    <v-file-input small-chips accept="image/*" label="첨부파일"></v-file-input>
                    </v-col>
                </v-row>
                <v-container fluid>
                    <v-checkbox v-model="checkbox" :label="`비밀글`"></v-checkbox>
                </v-container>

                <div class="text-right">
                    <v-btn large class="ma-2" @click="cancel">취소</v-btn>
                    <v-btn large class="ma-2" color="success" @click="register">등록</v-btn>
                </div>
            </v-form>
        </v-col>
        <v-col cols="12" md="4"/>
    </v-row>
</v-app>
</template>

<script>
  export default {
    data: () => ({
        valid:'',
        title: '',
        titleRules: [
            v => !!v || 'Title is required',
        ],
        checkbox: false
    }),
    methods: {
        cancel(){

        },
        register(){

        }
    }
  }
</script>