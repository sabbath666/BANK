FROM consul:1.4.2

COPY ./data ./data
RUN chmod -R 777 ./data

ENTRYPOINT consul agent -server -bootstrap-expect=1 -ui -data-dir=/data -client=0.0.0.0 -bind=0.0.0.0