import React, { useState } from 'react';
import axios from 'axios';

const UploadChuong = () => {
  const [files, setFiles] = useState([]);
  const [tieuDe, setTieuDe] = useState("");

  const handleFileChange = (e) => {
    setFiles(e.target.files);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formData = new FormData();
    for (let i = 0; i < files.length; i++) {
      formData.append("files", files[i]);
    }
    formData.append("tieuDe", tieuDe);

    try {
      const response = await axios.post("http://localhost:8081/api/upload/chuong", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });
      alert("Chương đã được tải lên thành công!");
      console.log(response.data);
    } catch (error) {
      console.error("Lỗi khi tải chương:", error);
      alert("Tải chương thất bại!");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Tiêu đề chương"
        value={tieuDe}
        onChange={(e) => setTieuDe(e.target.value)}
        required
      />
      <input type="file" multiple onChange={handleFileChange} required />
      <button type="submit">Tải lên chương</button>
    </form>
  );
};

export default UploadChuong;
