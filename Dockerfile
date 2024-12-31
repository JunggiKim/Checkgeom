# Redis 공식 이미지 사용
FROM redis:latest

EXPOSE 6379

# Redis 서버 실행
CMD ["redis-server"]
