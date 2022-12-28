var express = require('express');
var cookieParser = require('cookie-parser');
var app = express(); // app 객체 생성

app.use(cookieParser());

app.get('/count', function(req, res) {
  if (req.cookies.count) {// req.cookies.count의 값에 따라 결정, js에서는 값이 없으면 false로 치환됨
    var count = parseInt(req.cookies.count); // req.cookies.count = 쿠키의 값 req.cookies.(쿠키이름) 사용, parseInt = js 기본내장 함수 값을 강제 정수형으로 형변환 시켜주는 함수
  } else {
     
  }
  count += 1;
  res.cookie('count', count);
  res.send('count : ' + count);  
});

app.listen(3000, function() { // 3000 포트에 (파일).js 시작
  console.log('Connected 3000 port');
});