# bookshop
e-projectSemIV
API

====================================================================================

Blog
-GET METHOD-
http://localhost:8080/blog/get?pageSize=6  (Số data trong 1 trang).
http://localhost:8080/blog/get?pageSize=6&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8080/blog/get?pageSize=6&pageNo=0&sortBy=title  (sắp xếp theo tên cột).
http://localhost:8080/blog/get?pageSize=6&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8080/blog/findById?id=2  (lấy ra blog theo id)
http://localhost:8080/blog/findByTitle?title=blog7  (filter theo title).
http://localhost:8080/blog/image/wallpapersden.com_neon-shallows_5120x2880.jpg(link ảnh hoặc dowload)
-POST METHOD-
http://localhost:8080/blog/add  (các tham số cần truyền :file(multipart để upload),title,content,status).
-PUT METHOD-
http://localhost:8080/blog/update  (các tham số cần truyền :id,file(multipart để upload),title,content,status).
-DELETE METHOD-
http://localhost:8080/blog/delete?id=2  (xóa data theo id).

====================================================================================

Publisher
-GET METHOD-
http://localhost:8080/publisher/get?pageSize=5  (Số data trong 1 trang).
http://localhost:8080/publisher/get?pageSize=5&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8080/publisher/get?pageSize=5&pageNo=0&sortBy=title  (sắp xếp theo tên cột).
http://localhost:8080/publisher/get?pageSize=5&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8080/publisher/get?id=2  (lấy ra publisher theo id).
http://localhost:8080/publisher/findByName?name=publisher7  (filter theo name).
-POST METHOD-
http://localhost:8080/publisher/add  (các tham số cần truyền :name,address,status).
-PUT METHOD-
http://localhost:8080/publisher/update  (các tham số cần truyền :id,name,address,status).
-DELETE METHOD-
http://localhost:8080/publisher/delete?id=2  (xóa data theo id).

====================================================================================

Author
-GET METHOD-
http://localhost:8080/author/get?pageSize=5  (Số data trong 1 trang).
http://localhost:8080/author/get?pageSize=5&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8080/author/get?pageSize=5&pageNo=0&sortBy=name  (sắp xếp theo tên cột).
http://localhost:8080/author/get?pageSize=5&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8080/author/get?id=2  (lấy ra author theo id).
http://localhost:8080/author/findByName?name=author7 (filter theo name).
-POST METHOD-
http://localhost:8080/author/add  (các tham số cần truyền :name,status).
-PUT METHOD-
http://localhost:8080/author/update  (các tham số cần truyền :id,name,status).
-DELETE METHOD-
http://localhost:8080/author/delete?id=2  (xóa data theo id).

====================================================================================

Role
-GET METHOD-
http://localhost:8080/role/get?pageSize=5  (Số data trong 1 trang).
http://localhost:8080/role/get?pageSize=5&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8080/role/get?pageSize=5&pageNo=0&sortBy=name  (sắp xếp theo tên cột).
http://localhost:8080/role/get?pageSize=5&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8080/role/get?id=2  (lấy ra role theo id).
http://localhost:8080/role/findByName?name=role7 (filter theo name).
-POST METHOD-
http://localhost:8080/role/add  (các tham số cần truyền :name,status).
-PUT METHOD-
http://localhost:8080/role/update  (các tham số cần truyền :id,name,status).
-DELETE METHOD-
http://localhost:8080/role/delete?id=2  (xóa data theo id).

====================================================================================


