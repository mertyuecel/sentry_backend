FROM ubuntu:latest
LABEL authors="myu"

ENTRYPOINT ["top", "-b"]