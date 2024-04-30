# FastAPI를 통해 구현한 기능들은 모두 서버주소/redoc, 서버주소/docs 주소로 api문서를 자동 생성 해준다

from tkinter import PhotoImage
from unicodedata import name
from fastapi import FastAPI
app = FastAPI()

from fastapi.responses import FileResponse  # html등의 파일을 경로에 접속했을때 보여줄수 있는 모듈

@app.get("/")   # '/'는 메인페이지를 뜻함.
def main_server():
    return 'hello'  # 메인 페이지에 접속했을때 보여지는 정보

@app.get("/data")
def data_page(): 
    return FileResponse('index.html') # 위에서 import한 모듈 사용 FileResponse('파일경로') 파일 경로를 작성해주면 유저가 특정 주소에 접속하였을때
                                      # 파일을 전송해줄 수 있다.

'''
유저로부터 특정 데이터를 입력받으려면? (이름, 이메일, 아이디 등)
'''

from pydantic import BaseModel
# DB 입출력의 경우 이 위치에 데이터베이스  접속코드 작성

class rec_type(BaseModel): # 유저가 발신할 데이터 모델 생성. 모델을 생성할때는 클래스 명(BaseModel)을 사용 
     name : str # "데이터의 이름 : 타입"형식으로 작성 ex) 이름의 경우에는 문자열이므로 name : str
     phone : int

@app.post("/send") # 유저로부터 데이터를 수신 받으려면 @app.post를 사용, 예를 들어 app.post("/send")라면 send라는 url로 정보를 보내는 방식
def post_page(data : rec_type): # 보낸 데이터를 담아줄  
    print(data) # 유저가 전송한 데이터 출력
    # DB입출력의 경우 이 위치에 코드 작성(DB 입,출력)
    return '전송 완료 '

@app.get("/test")
async def async_page(): # def 앞부분에 async를 입력하면
    await print("await") # await를 사용 가능하게 된다. await란? 비동기처리기능 쉽게 말해, await 뒤에 사용한 코드의 처리가 오랜 시간이 걸리게 되면
                         # await 이후의 코드를 먼저 실행한다. 이 기능 덕분에 django, flask 등 프레임워크보다 빠른 처리가 가능
    return 'haha'