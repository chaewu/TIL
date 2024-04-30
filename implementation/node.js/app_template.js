var express = require('express');
var app = express(); // app 객체 생성

app.listen(3000, function() { // 3000 포트에 (파일).js 시작
  console.log('Connected 3000 port');
});