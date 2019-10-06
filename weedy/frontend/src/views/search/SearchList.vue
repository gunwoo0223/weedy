<template>
    <div>
        {{this.$route.params.name}}
    </div>
</template>

<script>
import axios from 'axios'

export default {
    created(){
        alert(this.$route.params.name);
        axios.get('/searchList/1')
                .then((response) => {
                    alert("searchList Data Access success!!");
                }).catch((ex) => {
                    alert("searchList Data Access Fail!!"+ ex);
                })
    },
}
</script>

<style scoped>

</style>