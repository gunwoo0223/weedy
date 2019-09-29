<template>
<v-app>
  <div>
    <v-data-table
      :headers="headers"
      :items="desserts"
      item-key="name"
      class="elevation-1"
      :search="search"
      :custom-filter="filterOnlyCapsText"
    >
      <!-- <template v-slot:top >
        <v-text-field v-model="search" label="Search" class="mx-4"></v-text-field>
      </template> -->
      <template v-slot:item.type="{ item }">
        <v-chip :color="getColor(item.type)" dark>{{ item.type }}</v-chip>
      </template>

      <template v-slot:body.append>
        <tr>
          <td>
              <v-text-field v-model="search" label="Search" class="mx-4"></v-text-field>
          </td>
          <td></td>
          <td colspan="4"></td>
        </tr>
      </template>
    </v-data-table>
  </div>
</v-app>
</template>

<script>
  export default {
    data () {
      return {
        search: '',
        desserts: [
          {
            id: '1',
            title: '궁금해요1',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변완료',
          },
          {
            id: '2',
            title: '궁금해요2',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변대기중',
          },
          {
            id: '3',
            title: '궁금해요3',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변완료',
          },
          {
            id: '4',
            title: '궁금해요4',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변대기중',
          },
          {
            id: '5',
            title: '궁금해요5',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변대기중',
          },
          {
            id: '6',
            title: '궁금해요',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 40,
            type: '답변완료',
          },
          {
            id: '7',
            title: '궁금해요',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변완료',
          },
          {
            id: '8',
            title: '궁금해요',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변완료',
          },
          {
            id: '9',
            title: '궁금해요',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변완료',
          },
          {
            id: '10',
            title: '궁금해요',
            userId: 'user01',
            updateTime: '2019.09.09',
            readCount: 4,
            type: '답변완료',
          },
        ],
      }
    },
    computed: {
      headers () {
        return [
          {
            text: '번호',
            align: 'left',
            value: 'id',
          },
          { text: '제목', value: 'title', align: 'center' },
          { text: '작성자', value: 'userId', align: 'center' },
          { text: '날짜', value: 'updateTime', align: 'center' },
          { text: '조회수', value: 'readCount', align: 'center' },
          { text: '답변상태', value: 'type', align: 'center' },
        ]
      },
    },
    methods: {
      filterOnlyCapsText (value, search, item) {
        return value != null &&
          search != null &&
          typeof value === 'string' &&
          value.toString().indexOf(search) !== -1
      },
      getColor (type) {
        if (type == '답변완료') return 'red'
        else if (type == '답변대기중') return 'orange'
      },
    },
  }
</script>