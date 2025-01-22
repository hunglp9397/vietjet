# Apply design pattern: Template method + Abstract factory


- Ưu điểm:
  + Cố định bộ khung là ưu điểm
- Nhược điểm: 
  + Cố định bộ khung cũng là nhược điểm
  + Vi phạm nguyên tắc Liskov, class con có thể thay đổi hoàn toàn method ở lớp cha
  + Nếu code tại baseService phình to thì sẽ gây ra tình trạng khó maintain.


