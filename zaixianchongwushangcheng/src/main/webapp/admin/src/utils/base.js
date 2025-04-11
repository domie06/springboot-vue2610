const base = {
    get() {
        return {
            url : "http://localhost:8080/zaixianchongwushangcheng/",
            name: "zaixianchongwushangcheng",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zaixianchongwushangcheng/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "在线宠物商城"
        } 
    }
}
export default base
