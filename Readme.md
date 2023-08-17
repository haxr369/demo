# Docker-compose를 이용한 springboot-mysql

* springboot 프로젝트는 로컬에서 빌드 후 dockerfile에서 jar 파일만 복사
* mysql은 alpaine image를 가지고 dockerfile에서 환경변수 주입
* ENV와 echo를 이용해서 처음 MySQL 컨테이너를 세팅하는 init.sql을 작성
