// nodemailer을 사용하기 위한 변수(?) 선언
const nodemailer = require("nodemailer");

// 이메일 정보 입력
const email = {
    host: "smtp.mailtrap.io",
    port: 2525,
    auth: {
      user: "7f86ad00045614",
      pass: "9d40d840dcb1fd"
    }
};

// if 에러 발생시 terminal에 error 내역 출력, else info.response(메일 발송 정보 출력)
const send = async (option) => {
    nodemailer.createTransport(email).sendMail(option, (error, info) => {
        if(error) {
            console.log(error);
        }
        else {
            console.log(info);
            return info.response;
        }
    });
};

// 메일 내용
let email_data = {
    from : '2022013@bssm.hs.kr',
    to : '2022013@bssm.hs.kr',
    subject: '테스트 메일 입니다.',
    text: 'nodejs studying'
}

send(email_data);