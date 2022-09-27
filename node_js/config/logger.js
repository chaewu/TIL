// node.js로 log관리 프로그램 만들기
// ㄴ> log란? 시스템을 운영했을때, 시스템에서 일어나는 모든 데이터를 관리하는 기록

const winston = require('winston');
const winstonDaily = require('winston-daily-rotate-file'); // 로그 파일을 일자별로 생성
const appRoot = require('app-root-path'); // nodejs가 동작하는 rootPath를 가져와주는 모듈
const process = require('process'); // nodejs가 운영되는 환경(개발 환경, 테스트 환경, 프로덕션 환경 등)을 알게해주는 모듈

const logDir = `${appRoot}/logs`; // logs 디렉토리 하위에 로그 파일을 저장, `${appRoot}/파일(폴더)`를 사용하면 입력한 파일의 path값을 반환
                                                                        // ㄴ> appRoot인 이유는? 코드 상단에 app-root-path를 appRoot라는 이름으로 정의

const { // winston.format 내부의 combine, timestamp등 총 4개의 메서드를 받아옴
    combine,
    timestamp,
    label,
    printf,
    
} = winston.format; // log를 로그파일에 기록할때 어떠한 형식으로 파일을 기록할지에 대한 인자

const logFormat = printf(({
    level,
    message,
    label,
    timestamp
}) => {
    return `${timestamp} [${label}] ${level}: ${message}`; // 실제 화면상에 표시될 로그 형식
}); // 순서대로 {타임스탬프(날짜, 시간, 분, 초)}, {시스템 이름}, {로그레벨(인포레벨, 원인레벨, 에러레벨 등)}, {로그내용}

/*
 * Log Level
 * error: 0, warn: 1, info: 2, http: 3, verbose: 4, debug:5, silly: 6
 */
const logger = winston.createLogger({
    format: combine(
        label({
            label: 'LogTestSystem' // 시스템 이름 정의
        }),
        timestamp({
            format: 'YYYY-MM-DD HH:mm:ss', 
        }),
        logFormat // log 출력 포맷
    ),
    transports: [
        // info 레벨 로그를 저장할 파일 설정
        new winstonDaily({
            level: 'info',
            datePattern: 'YYYY-MM-DD',
            dirname: logDir,
            filename: `%DATE%.log`,
            maxFiles: 30,
            zippedArchive: true,
        }),
        new winstonDaily({
            level: 'error',
            datePattern: 'YYYY-MM-DD',
            dirname: logDir,
            filename: `%DATE%.error.log`,
            maxFiles: 30,
            zippedArchive: true,
        })
    ],
    exceptionHandlers: [ // uncaughtException 발생시
        new winstonDaily({
            level: 'error',
            datePattern: 'YYYY-MM-DD',
            dirname: logDir,
            filename: `%DATE%.exception.log`,
            maxFiles: 30,
            zippedArchive: true,
        })
    ]
});

// Production 환경이 아닌 경우(dev 등)
if (process.env.NODE_ENV !== 'production') {
    logger.add(new winston.transport.Console({
        format: winston.format.combine(
            winston.format.colorize(),
            winston.format.simple(),
        )
    }));
}

module.exports = logger;