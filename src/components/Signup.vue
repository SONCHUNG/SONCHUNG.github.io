<template>
  <div class="canvas f-family">
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
        <form
          @submit.prevent="submit"
          id="signup-vue"
          action="signup"
          method="post"
        >     
        <br />양방향 바인딩 된 모델
        <br />pwd : {{ member.pwd }}
        <br />email : {{ member.email }}
        <br />code : {{ emailcode }}
        <br />emailconfirm : {{ emailconfirm }}

          <div class="input-field-2">
            <label for="uid" class="uid-label">
              <span class="d-none">uid</span>
              <input
                type="text"
                id="uid"
                name="uid"
                class="input-text-2"
                placeholder="아이디를 입력해주세요."
                v-model="member.uid"
              />
            </label>
          </div>
          <!-- @keyup="isValidpwd" -->
          <div class="input-field-2 m-t-1">
            <label for="password" class="password-label">
              <span class="d-none">pw</span>
              <input
                type="text"
                id="pwd"
                name="pwd"
                class="input-text-2"
                placeholder="비밀번호를 입력해주세요."
                v-model="member.pwd"
              />
              <div v-if="pwdError.length" style="color: red">
                {{ pwdError }}
              </div>
            </label>
          </div>

          <div class="input-field-2 m-t-1">
            <label for="password-confirm" class="password-confirm-label">
              <span class="d-none">pw-confirm</span>
              <input
                type="text"
                id="password-confirm"
                name="repassword"
                class="input-text-2"
                placeholder="비밀번호를 다시 입력해주세요."
                v-model="member.pwdConfirm"
              />
            </label>
          </div>

          <div class="input-field-2 m-t-1">
            <label for="name" class="name-label">
              <span class="d-none">name</span>
              <input
                type="text"
                id="name"
                name="name"
                class="input-text-2"
                placeholder="이름을 입력해주세요."
                v-model="member.name"
              />
            </label>
          </div>

          <div class="input-field-2 m-t-1">
            <label for="name" class="name-label">
              <span class="d-none">nickname</span>
              <input
                type="text"
                id="nickname"
                name="nickname"
                class="input-text-2"
                placeholder="닉네임을 입력해주세요."
                v-model="member.nickname"
              />
            </label>
          </div>

          <div class="input-field-2 m-t-1">
            <label for="email" class="email-label">
              <span class="d-none">email</span>
              <input
                type="text"
                id="email"
                name="email"
                class="input-text-2"
                placeholder="이메일을 입력해주세요."
                v-model="member.email"
              />
              <div v-if="emailError" style="color: red">{{ emailError }}</div>
              <input
                @click.prevent="checkEmail"
                class="btn-post"
                id="btn-post"
                type="button"
                value="전송"
              />
            </label>
          </div>

          <div class="input-field-2 m-t-1">
            <label for="email" class="email-confirm-label">
              <span class="d-none">email-confirm</span>
              <input
                type="text"
                id="email"
                name="reemail"
                class="input-text-2"
                placeholder="이메일 인증번호를 입력해주세요."
                v-model="emailconfirm"
              />
              <div v-if="emailcodeError" style="color: red">{{ emailcodeError }}</div>
              <input
                @click.prevent="checkEmailConfirm"
                class="btn-auth"
                id="btn-auth"
                type="button"
                value="확인"
              />
            </label>
          </div>

          <div class="d-fl-jf m-t-69px">
            <input class="btn-3" type="submit" value="가입하기" />
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
      member: {
        uid: "",
        pwd: "",
        pwdConfirm: "",
        name: "",
        nickname: "",
        email: "",
      },
      emailError: "",
      pwdError: "",
      emailconfirm: "",
      emailcode: "",
      emailcodeError: "",
      emailConfirmChk: false,
    };
  },
  methods: {
    async submit() {
      // 중복검사
      this.emailError = "";
      this.pwdError = "";
      console.log("test");
      if (!this.email) {
        this.emailError = "이메일 주소는 필수 입력사항입니다.";
      } else if (!this.isValidEmail(this.email)) {
        this.emailError = "올바른 이메일 주소를 입력해주세요.";
      }
      if (!this.pwd) {
        this.pwdError = "비밀번호는 필수 입력사항입니다.";
      } else if (this.pwd !== this.pwdConfirm) {
        this.pwdError = "비밀번호가 일치하지 않습니다.";
      } else if (!this.isValidpwd(this.pwd)) {
        this.pwdError = "올바른 비밀번호를 입력해주세요.(8자 이상 영어+숫자)";
      }
      if (!this.emailError && !this.pwdError) {
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        console.log(this.member);

        var raw = JSON.stringify(this.member);

        var requestOptions = {
          method: "POST",
          headers: myHeaders,
          body: raw,
          redirect: "follow",
        };

        fetch("http://localhost:8080/members", requestOptions)
          .then((response) => response.text())
          .then((result) => console.log(result))
          .catch((error) => console.log("error", error));
        console.log(
          "%가입완료",
          "background: green; color: white; display: block;"
        );
      }
    },
    isValidEmail(email) {
      const emailRegex = /\S+@\S+\.\S+/;
      return emailRegex.test(email);
    },
    isValidPwd(member) {
      // 비밀번호는 8자 이상이어야 합니다.
      if (this.pwd.length < 8) {
        this.pwdError = "올바른 비밀번호를 입력해주세요.(8자 이상 영어+숫자)";
        return false;
      }

      // 비밀번호는 영문자와 숫자를 반드시 포함해야 합니다.
      const hasLetter = /[a-zA-Z]/.test(pwd);
      const hasNumber = /\d/.test(pwd);
      if (!hasLetter || !hasNumber) {
        return false;
      }

      // 모든 검증을 통과한 경우 유효한 비밀번호입니다.
      return true;
    },
    validation(member) {
      console.log(
        "%cHello Signup.vue line:177 ",
        "background: green; color: white; display: block;"
      );
      this.emailError = "";
      this.pwdError = "";
      if (!this.email) {
        this.emailError = "이메일 주소는 필수 입력사항입니다.";
      } else if (!this.isValidEmail(this.email)) {
        this.emailError = "올바른 이메일 주소를 입력해주세요.";
      }
      if (!this.pwd) {
        this.pwdError = "비밀번호는 필수 입력사항입니다.";
      } else if (this.pwd !== this.pwdConfirm) {
        this.pwdError = "비밀번호가 일치하지 않습니다.";
      } else if (!this.isValidPwd(this.pwd)) {
        this.pwdError = "올바른 비밀번호를 입력해주세요.(8자 이상 영어+숫자)";
      }
    },
    async checkEmail() {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(
        "http://localhost:8080/members/mailConfirm?email=cndfuf75@gmail.com",
        requestOptions
      )
        .then((response) => response.text())
        .then((code) => {
          this.emailcode = code;
          console.log("emailcode : " + this.emailcode);
          console.log("code : " + code);
        })
        .catch((error) => console.log("error", error));
    },
    checkEmailConfirm() {
      if (this.emailconfirm == this.emailcode) {
        this.emailConfirmChk = true;
        this.emailcodeError = "인증번호 확인 완료";
      } else {
        this.emailConfirmChk = false;
        this.emailcodeError = "인증번호가 잘못되었습니다";
      }
    },
  },
  beforeCreate() {
    console.log("beforeCreate");
  },
  created() {
    console.log("created");
  },
  beforeMount() {
    // console.log("beforeMount");
  },
  mounted() {
    console.log("mounted");
  },
  beforeUpdate() {
    // console.log("beforeUpdate");
  },
  updated() {
    console.log("updated");
  },
  beforeUnmount() {
    // console.log("beforeUnmount");
  },
  unmounted() {
    console.log("unmounted");
  },
};
</script>
<style scoped>
@import url(/css/component/component.css);
@import url(/css/component/component-sign-up.css);
</style>
