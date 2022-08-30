const express = require('express');
const app = express();

// 로컬 서버를 주소 3100에 엶
const server = app.listen(3100, () => {
    console.log('Start Server : localhost 3100');
});

// ejs는 "Embedded JavaScript templating"의 약자. 현재 내가 사용한 기능은 로컬 파일을 서버에 불러와주는 용도로 사용했다.
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

// index.html을 localhost:3100으로 불러옴
app.get('/', function (req, res) {
    res.render('index.html')
})

// about.html을 localhost:3100/about으로 불러옴
app.get('/about', function (req, res) {
    res.render('about.html')
})

// db 정보 입력시 정상 작동
var mysql = require('mysql');
var pool  = mysql.createPool({
  connectionLimit : 10,
  host            : 'example.org',
  user            : 'bob',
  password        : 'secret',
  database        : 'my_db'
});

// if (위 내용란에 db 정보를 입력한다면) { 사용중인 db를 localhost:3100/db으로 불러옴 }
app.get('/db', function (req, res) {
    pool.getConnection(function(err, connection) {
        if (err) throw err; // not connected!
       
        // Use the connection
        connection.query('select * form Test', function (error, results, fields) {
            res.send(JSON.stringify(results));
            console.log('results', results);
          // When done with the connection, release it.
          connection.release();
       
          // Handle error after the release.
          if (error) throw error;
       
          // Don't use the connection here, it has been returned to the pool.
        });
      });
})

// 터미널에 나오는 모든 내용도 저장하고 싶었지만 지능의 부재로 인해 실패함. https://itgameworld.tistory.com/122를 참고해서 다음엔 시도 예정