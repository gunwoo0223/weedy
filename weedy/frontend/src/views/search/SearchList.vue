<template>
    <div>
        {{this.$route.params.id}}
    </div>
</template>

<script>
import axios from 'axios'

export default {
    created(){
        alert(this.$route.params.id);
        axios.get('/searchList/'+this.$route.params.id)
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