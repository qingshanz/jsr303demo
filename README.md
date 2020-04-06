# jsr303demo
jsr303 校验

# 参数校验
curl http://localhost:8080/name?name=a

# 分组校验
curl --request POST \
  --url http://localhost:8080/add \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --data '{\r\n  "name": "demoData",\r\n  "mobile": "11111111111",\r\n  "addressList": [\r\n"",null\r\n  ]\r\n  \r\n}'
  
  
  
curl --request POST \
  --url http://localhost:8080/query \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --data '{\r\n  "mobile": "11111111111"\r\n  \r\n}'

# MethodValidationPostProcessor实现原理分析
