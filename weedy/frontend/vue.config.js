module.exports = {


    //vue파일에 console.log 입력하면 에러나는 것 방지.
    chainWebpack: config => {
        config.module.rules.delete('eslint');
    },

    devServer: {
        //frontend port번호 설정
        port:7070,
        //frontend와 backend 연결을 위한 proxy 설정
        proxy: {
            '/': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^/': ''
                },
            }
        }
    }
}