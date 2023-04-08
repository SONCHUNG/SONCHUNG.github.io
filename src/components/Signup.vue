<template>
    <div class="canvas f-family ">
        <header class="d-fl fl-dir-col al-cen">
            <section>
                <span class="d-none">헤더</span>
                <div>
                    <router-link to="/login" class="icon icon-back">Back</router-link>
                </div>
                <div class="d-fl-jf">
                    <h1 class="logo-main logo-moduel logo-size1 m-t-44px">mo_deul</h1>
                </div>
                <div>
                <h1 class="logo title-3 m-t-42px">회원 가입</h1>
                </div>
            </section>
        </header>
<!-- ----------------------------------------------------------- -->
    <main class="m-t-31px">
      <!-- flex 시작 -->
        <div class="sign-up-container">
        
            <!-- 여러 개의 이벤트 요청하는 방법 -->
            <form @submit.prevent="[submit()]">

            <div class="input-field-2">
                <label for="uid" class="uid-label">
                <span class="d-none">uid</span>
                <input type="text" id="uid" name="uid" class="input-text-2" placeholder="아이디를 입력해주세요.">
                </label>
            </div>

            <div class="input-field-2 m-t-1">
                <label for="password" class="password-label">
                <span class="d-none">pw</span>
                <input type="text" id="password" name="password" class="input-text-2" placeholder="비밀번호를 입력해주세요." v-model="member.pwd">
                </label>
            </div>

            <div class="input-field-2 m-t-1">
                <label for="password-confirm" class="password-confirm-label">
                <span class="d-none">pw-confirm</span>
                <input type="text" id="password-confirm" name="password-confirm" class="input-text-2" placeholder="비밀번호를 다시 입력해주세요." v-model="pwdConfirm">
                </label>
                <div v-if="passwordError" style="color:red;">{{passwordError}}</div>
            </div>

            <div class="input-field-2 m-t-1">
                <label for="name" class="name-label">
                <span class="d-none">name</span>
                <input type="text" id="name" name="name" class="input-text-2" placeholder="이름을 입력해주세요.">
                </label>
            </div>

            <div class="input-field-2 m-t-1">
                <label for="name" class="name-label">
                <span class="d-none">nickname</span>
                <input type="text" id="nickname" name="nickname" class="input-text-2" placeholder="닉네임을 입력해주세요.">
                </label>
            </div>
    
            <div class="input-field-2 m-t-1">
                <label for="email" class="email-label">
                <span class="d-none">email</span>
                <input type="text" id="email" name="email" class="input-text-2" placeholder="이메일을 입력해주세요.">
                <input class="btn-post" id="btn-post" type="button" value="전송">
                </label>
            </div>

            <div class="input-field-2 m-t-1">
                <label for="email" class="email-confirm-label">
                <span class="d-none">email-confirm</span>
                <input type="text" id="email" name="email" class="input-text-2" placeholder="이메일 인증번호를 입력해주세요.">
                <input class="btn-auth" id="btn-auth" type="button" value="확인">
                </label>
            </div>
                
                <div class="d-fl-jf m-t-69px">
                <input class="btn-3" type="submit" value="가입하기" >
                </div>
            </form>
        </div>
      <!-- flex 끝 -->


        </main>
  
    </div>

</template>


<script>
export default {
    data() {
        return {
            member:{
                uid:'sdfdsf',
                pwd:'kasd12312',
                name:'라플라',
                nickname:'요플레',
                email:'sdfi213@google.com',
                
            },
            pwdConfirm:"",
            passwordError:""
        }
    },
    methods: {


        async submit(){
            console.log("submit");
            this.passwordError = "";

            if (!this.member.pwd){
                this.passwordError="비밀번호를 입력해주세요";
            } else if (this.member.pwd !== this.pwdConfirm){
                this.passwordError="비밀번호가 일치하지 않습니다. 다시 입력해주세요";
            } else if (!this.isValidPassword(this.member.pwd)){
                this.passwordError="비밀번호가 올바르지 않습니다. 다시 입력해주세요";
            }
        },

        // isValidPassword(pwd){

        //     // 비밀번호 8자 이상 입력하기!
        //     if(this.member.pwd.length < 8){
        //         return false;
        //     }

        //     // '/[a-zA-z]/'를 정규식 이용해서 글자 규칙 테스트
        //     const hasLetter = /[a-zA-z]/.test(this.member.pwd);
        //     const hasNumber = /\d/.test(this.member.pwd);

        //     // 검증 끝나면 유효한 비밀번호 사용하기!
        //     if(!hasLetter || !hasNumber){
        //         return true;
        //     }

        // }

        
    },
}
</script>


<style scoped>
    @import "/css/component/component.css";
    @import "/css/component/component-sign-up.css";
</style>
