import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom"; // Import hook useParams
import apiMain from '../../api/apiMain'
import  './Chapter.scss'


const Chapter = () => {
  const { url, chapnum } = useParams(); // Lấy url và chapnum từ URL
  const [chapterData, setChapterData] = useState(null); // Lưu dữ liệu chương
  const [loading, setLoading] = useState(true); // Trạng thái loading
  const [error, setError] = useState(null); // Lưu lỗi nếu có

  useEffect(() => {
    const fetchChapter = async () => {
      try {
        setLoading(true); // Bắt đầu loading
        const data = await apiMain.getChapter(url, parseInt(chapnum, 10)); // Gọi API với url và chapnum
        setChapterData(data); // Lưu dữ liệu chương
      } catch (err) {
        setError("Không thể tải chương này, vui lòng thử lại.");
      } finally {
        setLoading(false); // Kết thúc loading
      }
    };

    fetchChapter(); // Gọi hàm lấy dữ liệu khi component mount
  }, [url, chapnum]); // Chạy lại khi URL hoặc chapnum thay đổi

  if (loading) return <p>Đang tải chương...</p>; // Hiển thị khi đang tải
  if (error) return <p>{error}</p>; // Hiển thị lỗi

  return (
    <div className="chapter-reader">
      <h2>{chapterData.tenchap}</h2>
      <div className="image-list">
        {chapterData.danhSachAnh.map((imageUrl, index) => (
          <img 
            key={index} 
            src={imageUrl} 
            alt={`Page ${index + 1}`} 
            className="chapter-image"
          />
        ))}
      </div>
    </div>
  );
};

export default Chapter;
