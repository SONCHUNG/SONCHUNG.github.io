Vue
.createApp({
    data(){
        return{
            test:"hello test",
            isActive: false,
            stuff:{
                title:"제목",
                place:"장소",
                numPeople:2,
                price:"가격",
                url:"url",
                content:"content",
                deadline:"2023-11-10T11:22"
            },
            category:{
                id:0,
                name:"카테고리제목"
            },
            file: '',
            fileObj:[]
        }

    },
    methods:{
        testHandler(e){
            console.log("testClick");
        },
        // 카테고리선택창 전환(reg1->reg2)
        dnoneHandler(isActive){
            this.isActive = !this.isActive;
            console.log(this.isActive);
        },
        // 인원수 조절
        numPeoplePlusHandler(stuff){
            if(this.stuff.numPeople>=1 && this.stuff.numPeople<16)
                this.stuff.numPeople++;
        },
        numPeopleMinusHandler(stuff){
            if(this.stuff.numPeople>=2 && this.stuff.numPeople<=16)
            this.stuff.numPeople--;
        },
        // POST 요청
        regStuffHandler(e){
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            var raw = JSON.stringify(this.stuff);

            var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
            };

            fetch("http://localhost:8080/stuffs/uploadImg", requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        },
        regImgHandler(e){
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "multipart/form-data");

            console.log("change!!!");
            console.log(e.target.files);
            this.file = e.target.files[0];
            console.log("fileName : " + this.file.name);
            console.log("fileSize : " + this.file.size);
            console.log("fileType(MimeType) : " + this.file.type);

            if(!this.fileCheck(this.file.name, this.file.size)){
                return false;
            }
            alert("파일이 업로드 되었습니다.");

            var formdata = new FormData();
            formdata.append("imgs", this.file)
            // for(let i=0; i<this.file.length; i++){
            //     formdata.append("uploadfile", this.file)
            // }

            var requestOptions2 = {
            method: 'POST',
            headers: myHeaders,
            body: formdata,
            redirect: 'follow'
            };

            fetch("http://localhost:8080/stuffs/uploadImg", requestOptions2)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        },
        fileCheck(fileName, fileSize){
            let regex = new RegExp("(.*?)\.(jpg|png)$");
            let maxSize = 10485760; //10MB

            if(fileSize >= maxSize){
                alert("파일 사이즈 초과");
                return false;
            }
            if(!regex.test(fileName)){
                alert("해당 종류의 파일은 업로드할 수 없습니다.");
                return false;
            }
            
            return true;
        }
    },
    beforeCreate(){console.log("beforeCreate")},
	created(){console.log("created")},
	beforeMount(){console.log("beforeMount")},
    mounted(){console.log("mounted");},
	beforeUpdate(){console.log("beforeUpdate")},
	updated(){console.log("updated")},
	beforeUnmount(){console.log("beforeUnmount")},
	unmounted(){console.log("unmounted")}
})
.mount("#reg-vue");
