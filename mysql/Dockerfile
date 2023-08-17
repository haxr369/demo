FROM mysql:8.1.0

# 환경 변수로 SQL 명령어 설정
#ENV MYSQL_USER=myspringboot \
#    MYSQL_PASSWORD=3219 \
#    MYSQL_DATABASE=myfirstdb \
#    MYSQL_HOST=spring-app

# init.sql 파일 생성
# /docker-entrypoint-initdb.d -> 이 디렉토리 안에 SQL파일은 MySQL 컨테이너가 처음 시작되면 자동으로 실행됨.
# '>' : 오버라이트, 파일이 있으면 덮어쓰고 없으면 생성
# '>>' : 추가, 파일이 있으면 내용을 끝에 추가, 없으면 생성
#RUN echo "CREATE USER IF NOT EXISTS '$MYSQL_USER'@'$MYSQL_HOST' IDENTIFIED BY '$MYSQL_PASSWORD';" > /docker-entrypoint-initdb.d/init.sql && \
#    echo "GRANT ALL PRIVILEGES ON $MYSQL_DATABASE.* TO '$MYSQL_USER'@'$MYSQL_HOST';" >> /docker-entrypoint-initdb.d/init.sql && \
#    echo "FLUSH PRIVILEGES;" >> /docker-entrypoint-initdb.d/init.sql

EXPOSE 3306