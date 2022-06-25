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
http://localhost:8080/blog/add  (các tham số cần truyền :file 'multipart để upload',title,content,status).
-PUT METHOD-
http://localhost:8080/blog/update  (các tham số cần truyền :id,file(multipart để upload),title,content,status).
-DELETE METHOD-
http://localhost:8080/blog/delete?id=2  (xóa data theo id).

====================================================================================

Book
-GET METHOD-
http://localhost:8080/book/get?pageSize=6  (Số data trong 1 trang).
http://localhost:8080/book/get?pageSize=6&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8080/book/get?pageSize=6&pageNo=0&sortBy=name  (sắp xếp theo tên cột).
http://localhost:8080/book/get?pageSize=6&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8080/book/findById?id=2  (lấy ra book theo id)
http://localhost:8080/book/findByName?name= aot  (filter theo name).
http://localhost:8080/book/image/fantasy-wallpaper-20092816354848.webp(link ảnh hoặc dowload)
-POST METHOD-
http://localhost:8080/book/add  (các tham số cần truyền :file 'multipart để upload',name,price,quantity,status,
categories 'cái này là mảng',authors 'cái này là mảng',publisher 'tên nhà xuất bản').
-PUT METHOD-
http://localhost:8080/book/update  (các tham số cần truyền :id,file(multipart để upload),name,price,quantity,status,
categories 'cái này là mảng',authors 'cái này là mảng',publisher 'tên nhà xuất bản').
-DELETE METHOD-
http://localhost:8080/book/delete?id=2  (xóa data theo id).

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

Category
-GET METHOD-
http://localhost:8081/category/get?pageSize=6  (Số data trong 1 trang).
http://localhost:8081/category/get?pageSize=6&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8081/category/get?pageSize=6&pageNo=0&sortBy=name  (sắp xếp theo tên cột).
http://localhost:8081/category/get?pageSize=6&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8081/category/findById?id=1  (lấy ra Category theo id)
http://localhost:8081/category/findByName?name=action  (filter theo name).
-POST METHOD-
http://localhost:8081/category/add  (các tham số cần truyền :name,status).
-PUT METHOD-
http://localhost:8081/category/update  (các tham số cần truyền :id,name,status).
-DELETE METHOD-
http://localhost:8081/category/delete?id=1 (xóa data theo id).

====================================================================================
Author
-GET METHOD-
http://localhost:8081/author/get?pageSize=6  (Số data trong 1 trang).
http://localhost:8081/author/get?pageSize=6&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8081/author/get?pageSize=6&pageNo=0&sortBy=name  (sắp xếp theo tên cột).
http://localhost:8081/author/get?pageSize=6&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8081/author/findById?id=1  (lấy ra author theo id)
http://localhost:8081/author/findByName?name=nguyen hai dang  (filter theo name).
-POST METHOD-
http://localhost:8081/author/add  (các tham số cần truyền: name,status).
-PUT METHOD-
http://localhost:8081/author/update  (các tham số cần truyền :id,name,status).
-DELETE METHOD-
http://localhost:8081/author/delete?id=1 (xóa data theo id).

====================================================================================

Login & Register & phân quyền(User)
-GET METHOD-
http://localhost:8080/user/get?pageSize=5  (Số data trong 1 trang).
http://localhost:8080/user/get?pageSize=5&pageNo=0&  (trang thứ nhất bắt đầu bằng 0).
http://localhost:8080/user/get?pageSize=5&pageNo=0&sortBy=title  (sắp xếp theo tên cột).
http://localhost:8080/user/get?pageSize=5&pageNo=0&sortBy=content&sortDir=asc  (kiểu sắp xếp tăng hoặc giảm).
http://localhost:8080/user/get?id=2  (lấy ra publisher theo id).
http://localhost:8080/user/findByName?name=dang  (filter theo name).
-POST METHOD-
http://localhost:8080/auth/signup(đăng ký ví dụ:
{
    "name":"dang",
    "username":"mod1",
    "password":"1234$",
    "phone":"0987456321",
    "email":"nguyenhaidang25072001@gmail.com",
    "address":"da nang",
    "gender":true,
    "status":true,
    "role":["mod","user"] 
}
trong role truyền các quyền (có 3 quyền admin, mod, user nếu không thêm role quyền mặc định là user).
http://localhost:8080/auth/signin(đăng nhập ví dụ:
{
    "username":"mod1",
    "password":"1234$"
}
đăng nhập thành công sẽ trả về thông tin user và token và type).
-PUT METHOD-
http://localhost:8080/user/update  (các tham số cần truyền :id,name,username,password,phone,email,address,gender,status,role[]).-DELETE METHOD-
http://localhost:8080/user/delete?id=2  (xóa data theo id).