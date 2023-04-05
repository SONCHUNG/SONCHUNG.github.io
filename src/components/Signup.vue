<template>
  <body>
  
    <div class="canvas f-family ">
      <header class="d-fl fl-dir-col al-cen">
        <section>
            <span class="d-none">헤더</span>
            <div>
                <a href="./login.html" class="icon icon-back">Back</a>
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
           
        
        <!-- action이 필요하다. signup으로 form을 제출하면 @PostMapping된 컨트롤러에서 찾는다.-->
            <form id="signup-vue" action="signup" method="post">
    
              <div class="input-field-2">
                <label for="uid" class="uid-label">
                  <span class="d-none">uid</span>
                <input type="text" id="uid" name="uid" class="input-text-2" placeholder="아이디를 입력해주세요."
                  v-model="uid">
                </label>
               </div>
    
               <div class="input-field-2 m-t-1">
                <label for="password" class="password-label">
                  <span class="d-none">pw</span>
                <input type="text" id="password" name="password" class="input-text-2" placeholder="비밀번호를 입력해주세요."
                  v-model="password">
                  <div v-if="passwordError" style="color: red;">{{ passwordError }}</div>
                </label>
              </div>
    
              <div class="input-field-2 m-t-1">
                <label for="password-confirm" class="password-confirm-label">
                  <span class="d-none">pw-confirm</span>
                <input type="text" id="password-confirm" name="repassword" class="input-text-2" placeholder="비밀번호를 다시 입력해주세요."
                  v-model="passwordConfirm">
                </label>
              </div>
    
              <div class="input-field-2 m-t-1">
                <label for="name" class="name-label">
                  <span class="d-none">name</span>
                <input type="text" id="name" name="name" class="input-text-2" placeholder="이름을 입력해주세요."
                  v-model="name">
                </label>
              </div>
              
              <div class="input-field-2 m-t-1">
                <label for="name" class="name-label">
                  <span class="d-none">nickname</span>
                <input type="text" id="nickname" name="nickname" class="input-text-2" placeholder="닉네임을 입력해주세요."
                  v-model="nickname">
                </label>
              </div>
      
              <div class="input-field-2 m-t-1">
                <label for="email" class="email-label">
                  <span class="d-none">email</span>
                <input type="text" id="email" name="email" class="input-text-2" placeholder="이메일을 입력해주세요."
                  v-model="email">
                  <div v-if="emailError" style="color: red;">{{ emailError }}</div>
                <input class="btn-post" id="btn-post" type="button" value="전송">
                </label>
               </div>
    
               <div class="input-field-2 m-t-1">
                <label for="email" class="email-confirm-label">
                  <span class="d-none">email-confirm</span>
                <input type="text" id="email" name="reemail" class="input-text-2" placeholder="이메일 인증번호를 입력해주세요.">
                <input class="btn-auth" id="btn-auth" type="button" value="확인">
                </label>
               </div>
                
                <div class="d-fl-jf m-t-69px">
                  <input class="btn-3" @click.prevent="submit" type="submit" value="가입하기">
                </div>
            </form>
          </div>
          <!-- flex 끝 -->
    
    
        </main>
      
    </div>
    
    </body>
</template>

<script>
    export default{
        data(){
        return{
            uid:"",
            password: "",
            passwordConfirm: "",
            name: "",
            nickname: "",
            email: "",
            emailError: "",
            passwordError: ""
        }
    },
    methods:{async submit() {
        this.emailError = "";
        this.passwordError = "";
        if (!this.email) {
            this.emailError = "Email is required";
        } else if (!this.isValidEmail(this.email)) {
            this.emailError = "Please enter a valid email address";
        }
        if (!this.password) {
            this.passwordError = "Password is required";
        } else if (this.password !== this.passwordConfirm) {
            this.passwordError = "Passwords do not match";
        } else if (!this.isValidPassword(this.password)) {
            this.passwordError = "Passwords do not valid";
        }
        if (!this.emailError && !this.passwordError) {
            const response = await fetch("/api/signup", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    name: this.name,
                    email: this.email,
                    password: this.password
                })
            });
            const data = await response.json();
            console.log(data);
        }
    },
    isValidEmail(email) {
        const emailRegex = /\S+@\S+\.\S+/;
        return emailRegex.test(email);
    },
    isValidPassword(password) {
        // 비밀번호는 8자 이상이어야 합니다.
        if (password.length < 8) {
            return false;
        }
    
        // 비밀번호는 영문자와 숫자를 반드시 포함해야 합니다.
        const hasLetter = /[a-zA-Z]/.test(password);
        const hasNumber = /\d/.test(password);
        if (!hasLetter || !hasNumber) {
            return false;
        }
    
        // 모든 검증을 통과한 경우 유효한 비밀번호입니다.
        return true;
    }

    }
    }
</script>

<style scoped>
@import '../assets/component/component-sign-up.css';
</style>