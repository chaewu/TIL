const express = require('express');
const app = express();

app.listen(8080, function(){ // 내 컴퓨터에 서버를 열어줌. 만약 listen(3000, )라면 로컬호스트 3000에 서버를 열어준다
    console.log('listening on 8080')
}); 

// 누군가가 /pet으로 방문하면 pet 관련된 안내 표시
app.get('/pet', function(req, res){ // req = request(요청) | res = response(응답)
    res.send('펫용품을 쇼핑할 수 있는 페이지 입니다.');
});