1. docker run --name redisServer -p 6379:6379 redis ile kurulum 
2. docker run redis : ile redis çalıştırdık
3. docker exec -it <name-container> redis-cli  : cli üzerinden çalışabiliriz. 
    ** docker ps ile çalışan container name leri görebiliriz. 
4. KEYS * : tüm keyler listelenir. 
5. SET <key> <value> :  buraya veri setleriz. 
6. GET <Key> : keyin value değeri görüntülenir. 
7. EXIST <key> : bu keyin olup olmadığını görüntüleriz.
8. append <key> <value> : Bu durumda key yoksa oluşturup değer setlenir,varsa key değerine ekleme yaparız. 
9. hset  <hsetname> <key> <value> : hset olarak da veri setleriz
10. hset çağırmak istenilidğin "Operation agains a key holding the wrong kind of value" hatası
    ** bunun yerne hgets <hsetname> kullanırız.
11. SET <key> <value>  EX  10 : 10 sn sonra siler. 
12. PUBLISH <subscribeName> "Mesaaage" : bir kanala mesaj gönderir. 
13. SUBSCRIBE <name> :  oluşturduk bekleriz publisher tarafından gönderilen mesajlar burada gösterilir. 
14. 