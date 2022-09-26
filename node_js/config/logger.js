const winston = require('winston');
const winstonDaily = require('winston-daily-rotate-file');
const appRoot = require('app-root-path');
const process = require('process');

const logDir = `${appRoot}/logs`;

const {
    combine,
    timestamp,
    label,
    printf
} = winston.format

const logFormat = printf(({
    level,
    message,
    lable,
    timestamp
}) => {
    return `${timestamp} [${label}] ${level}: ${message}`;
});

