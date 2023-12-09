# Bài tập môn lập trình WWW với công nghệ java tuần 5
### Họ và tên: Nguyễn Tấn Huy
### MSSV: 20068791
## Các chức năng:
1. Hiển thị danh sách tất cả candidate
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/a62e2762-be18-4711-a722-10d60a78f2bc)
2. Hiển thị trang Candidate Paging
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/2184e8d9-01a9-478d-9245-c89f833ee8c2)
3. Thêm mới một candidate
- Màn hình thêm mới candidate:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/dd6e07c5-7080-452b-8d1c-b52f47b296eb)
- Sau khi thêm mới thành công sẽ quay lại trạng candidate paging và hiện thông báo:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/ca536372-804a-425e-945a-a93651bcc31f)
- Thêm lại một lần nữa ứng viên có số điên thoại như ứng viện vừa thêm thì sẽ báo lỗi và không cho thêm:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/e2fd9fa1-cd99-49ad-a751-fae719e6ba7d)
4. Cập nhật thông tin candidate
- Cập nhật số điện thoại: 
Ở đây cập nhật số điện thoại thì phải là một số điện thoại chưa có trong danh sách candidate
Cập nhật candidate có id là 1, sửa số điện thoại thành 9581395239 trùng với candidate có id là 2 sẽ có thông báo và không cho cập nhật:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/463bd0c2-d4ed-44bf-b204-86e836df09ad)
Sửa lại số điện thoại khác không bị trùng thì sẽ cập nhật thành công vào hiện thông báo:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/32274e5a-5523-4c8d-b884-73ec8a24aad3)
Ở đây sửa số điện thoại thành 0001395239 không bị trùng.
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/06964c8a-19ea-46d9-84a6-66d1eeb0255d)
- Cập nhật các thông tin khác:
Tiếp tục với candidate có id là 1:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/f6761389-440a-4b0e-8756-b8c508f47b80)
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/a37bfbaa-fddc-4200-b6c5-f56b7980e550)
5. Xóa một candidate
Xóa candidate có id là 1:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/1955c498-6c57-487a-a1f0-48da04abf461)
Xóa thành công:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/37b9aa66-c474-49ae-b108-97351538c988)
7. Ứng viên login vào thì gợi ý các công việc phù hợp với các skill mà ứng viên có:
- Màn hình login:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/2879ec58-8d74-4f30-95e3-5d150a04e1ce)
Ở mà hình này login bằng số điện thoại vì khi thêm vào candidate mới trong chức năng add candidate có kiểm tra xem số điện thoại đã tồn tại hay chưa, nếu chưa sẽ ko thêm được, nên 1 số điện thoại chỉ tương ứng với 1 ứng viên.
- Login thành công thì sẹ hiện danh sách các công việc gợi ý dựa trên các skill mà ứng viên có:
![image](https://github.com/Huy0205/WWW_Lab05/assets/144652046/a3d9fde5-1b87-4d34-a386-e11286b91b29)
