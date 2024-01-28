FROM ubuntu:latest
LABEL authors="gteti"

ENTRYPOINT ["top", "-b"]