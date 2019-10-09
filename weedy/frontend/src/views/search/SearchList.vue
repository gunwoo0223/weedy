<template>
    <div>
        {{this.$route.params.id}}
        <br>
        
    </div>
</template>

<script>
import axios from 'axios'

export default {
    created(){
        axios.get('/searchList/'+this.$route.params.id)
                .then((response) => {
                    alert("searchList Data Access success!!");

                    this.appListInfo.push({id: response.data.id, name:response.data.name, url:response.data.url});

                    alert(response.data.id);
                    alert(response.data.name);
                    alert(response.data.url);
                }).catch((ex) => {
                    alert("searchList Data Access Fail!!"+ ex);
                })
    },
    data: ()=>({
        appListInfo:[],
    }),
}
</script>

<style scoped>

</style>