#!/bin/bash
#启动服务器
echo "服务启动中..."
java -Xms500m -Xmx500m -jar bin/activiti-test-0.0.1-SNAPSHOT.jar
echo "服务启动成功..."
