FROM ubuntu:latest
LABEL authors="juampis"

ENTRYPOINT ["top", "-b"]