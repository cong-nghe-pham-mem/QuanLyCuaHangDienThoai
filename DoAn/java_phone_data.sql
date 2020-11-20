-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3308
-- Thời gian đã tạo: Th6 23, 2020 lúc 03:38 PM
-- Phiên bản máy phục vụ: 5.7.28
-- Phiên bản PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java_phone_data`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

DROP TABLE IF EXISTS `chitietphieunhap`;
CREATE TABLE IF NOT EXISTS `chitietphieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` int(10) NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL,
  `DonGia` float UNSIGNED NOT NULL,
  PRIMARY KEY (`MaPN`,`MaSP`),
  KEY `MaSP` (`MaSP`),
  KEY `MaPN` (`MaPN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('PN1', 8, 2, 23),
('PN1', 24, 10, 25),
('PN10', 11, 1, 24990000),
('PN11', 14, 1, 24490000),
('PN11', 15, 1, 25990000),
('PN12', 10, 1, 20490000),
('PN12', 11, 1, 24990000),
('PN12', 13, 1, 28990000),
('PN2', 3, 35, 7.9),
('PN3', 1, 5, 20),
('PN4', 1, 1, 20),
('PN4', 7, 1, 15.4),
('PN4', 12, 1, 7.9),
('PN4', 14, 1, 5.5),
('PN5', 1, 1, 20),
('PN5', 11, 1, 15.9),
('PN5', 14, 1, 5.5),
('PN5', 15, 1, 5.5),
('PN6', 10, 1, 23.9),
('PN6', 15, 10, 5.5),
('PN6', 17, 5, 5.6),
('PN7', 21, 100, 8),
('PN7', 22, 10, 39),
('PN8', 16, 10, 11.9),
('PN9', 1, 10, 20);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi tiết khuyến mãi`
--

DROP TABLE IF EXISTS `chi tiết khuyến mãi`;
CREATE TABLE IF NOT EXISTS `chi tiết khuyến mãi` (
  `mã giảm giá` int(11) NOT NULL,
  `mã sản phẩm` int(11) NOT NULL,
  `số tiền giảm` int(11) NOT NULL,
  PRIMARY KEY (`mã giảm giá`,`mã sản phẩm`),
  KEY `mã sản phẩm` (`mã sản phẩm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi tiết sản phẩm`
--

DROP TABLE IF EXISTS `chi tiết sản phẩm`;
CREATE TABLE IF NOT EXISTS `chi tiết sản phẩm` (
  `Mã chi tiết` int(11) NOT NULL,
  `Mã sản phẩm` int(11) NOT NULL,
  `Mã danh mục` char(255) NOT NULL,
  `Kích thước` varchar(255) NOT NULL,
  `Trọng lượng` varchar(255) NOT NULL,
  `Màu sắc` varchar(255) NOT NULL,
  `Bộ nhớ trong` varchar(255) NOT NULL,
  `Bộ nhớ đệm/Ram` varchar(255) NOT NULL,
  `Hệ điều hành` varchar(255) NOT NULL,
  `Camera trước` varchar(255) NOT NULL,
  `Camera sau` varchar(255) NOT NULL,
  `Pin` varchar(255) NOT NULL,
  `Bảo hành` varchar(255) NOT NULL,
  `Tình trạng` varchar(255) NOT NULL,
  `Hình ảnh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Mã chi tiết`),
  UNIQUE KEY `Mã sản phẩm` (`Mã sản phẩm`),
  KEY `Chi tiết sản phẩm_ibfk_1` (`Mã sản phẩm`),
  KEY `Chi tiết sản phẩm_ibfk_2` (`Mã danh mục`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chi tiết sản phẩm`
--

INSERT INTO `chi tiết sản phẩm` (`Mã chi tiết`, `Mã sản phẩm`, `Mã danh mục`, `Kích thước`, `Trọng lượng`, `Màu sắc`, `Bộ nhớ trong`, `Bộ nhớ đệm/Ram`, `Hệ điều hành`, `Camera trước`, `Camera sau`, `Pin`, `Bảo hành`, `Tình trạng`, `Hình ảnh`) VALUES
(1, 1, 'IP', '150.9mm - 75.7mm - 8.3mm\r\n', '194 g\r\n', 'Trắng, Đen, Xanh, Đỏ', '64 GB\r\n', '4 GB', 'IOS', '12 MP, ƒ/2.2 aperture\r\n', 'Camera kép 12MP:\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3110 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam.', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11.png'),
(2, 2, 'IP', '150.9mm - 75.7mm - 8.3mm\r\n', '194 g\r\n', 'Trắng, Đen, Xanh, Đỏ', '128 GB\r\n', '4 GB', 'IOS', '12 MP, ƒ/2.2 aperture\r\n', 'Camera kép 12MP:\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3110 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam.', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11b.png'),
(3, 3, 'IP', '150.9mm - 75.7mm - 8.3mm\r\n', '194 g\r\n', 'Trắng, Đen, Xanh, Đỏ', '256 GB\r\n', '4 GB', 'IOS', '12 MP, ƒ/2.2 aperture\r\n', 'Camera kép 12MP:\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3110 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam.', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11c.png'),
(4, 4, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '188 g', 'Đen, Bạc, Gold', '64 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11pro1.png'),
(5, 5, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '188 g', 'Đen, Bạc, Gold', '256 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11pro2.png'),
(6, 6, 'IP', '144.0mm - 71.4mm - 8.1mm\r ', '188 g', '188 g', '188 g', 'IOS', '12 MP ƒ/2.2 aperture\r ', '3 Camera 12MP:\r - Camera tele: ƒ/2.0 aperture\r - Camera góc rộng: ƒ/1.8 aperture\r - Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r ', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'Máy mới 100%, chính hãng', 'image/iphone/iphone11pro3.png'),
(7, 7, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '226g\r\n', 'Đen, Bạc, Gold', '64 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11promax1.png'),
(8, 8, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '226g\r\n', 'Đen, Bạc, Gold', '256 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11promax2.png'),
(9, 9, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '226g\r\n', 'Đen, Bạc, Gold', '512 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphone11promax3.png'),
(10, 10, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '177g', 'Gold', '64 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonexs64gb.png'),
(11, 11, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '177g', 'Bạc', '256 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonexs256gb.png'),
(12, 12, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '177g', 'Đen', '256 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonexs512gb.png'),
(13, 13, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '208 g\r\n', 'Bạc,Gold', '64 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonexs256gb.png'),
(14, 14, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '208 g\r\n', 'Gold', '256GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonexs64gb.png'),
(15, 15, 'IP', '144.0mm - 71.4mm - 8.1mm\r\n', '208 g\r\n', 'Xám', '512 GB', '4 GB', 'IOS', '12 MP ƒ/2.2 aperture\r\n', '3 Camera 12MP:\r\n- Camera tele: ƒ/2.0 aperture\r\n- Camera góc rộng: ƒ/1.8 aperture\r\n- Camera siêu rộng: ƒ/2.4 aperture', '3046 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonexs512gb.png'),
(16, 16, 'IP', '143.6 x 70.9 x 7.7 mm (5.65 x 2.79 x 0.30 in)\r\n', '174 g (6.14 oz)\r\n', 'Bạc, Xám', '64 GB', '4 GB', 'IOS', '7 MP (f/2.2, 32mm), 1080p@30fps, 720p@240fps, nhận diện khuôn mặt, HDR\r\n', '12 MP (f/1.8, 28mm) + 12 MP (f/2.4, 52mm), tự động lấy nét nhận diện theo giai đoạn, 2x zoom quang học, OIS, 4 LED flash (2 tone)', 'Li-ion 2716 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam.', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonex64gb1.png'),
(17, 17, 'IP', '143.6 x 70.9 x 7.7 mm (5.65 x 2.79 x 0.30 in)\r\n', '174 g (6.14 oz)\r\n', 'Bạc, Xám', '256 GB', '4 GB', 'IOS', '7 MP (f/2.2, 32mm), 1080p@30fps, 720p@240fps, nhận diện khuôn mặt, HDR\r\n', '12 MP (f/1.8, 28mm) + 12 MP (f/2.4, 52mm), tự động lấy nét nhận diện theo giai đoạn, 2x zoom quang học, OIS, 4 LED flash (2 tone)', 'Li-ion 2716 mAh\r\n', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành của Apple Việt Nam.', 'Máy mới 100% , chính hãng Apple Việt Nam.', 'image/iphone/iphonex256gb.png'),
(18, 18, 'SS', '71.8 mm x 151 mm x 7.9 mm\r\n', '168 g\r\n', 'Đen,Đỏ', '256 GB\r\n', '8 GB\r\n', 'Android', '10 MP (F2.2)\r\n', '- Góc siêu rộng: 16MP (F2.2)\r\n- Góc rộng: 12MP OIS (F.15/F2.4)\r\n- Tele: 12MP OIS (F2.1)', '3500 mAh, sạc nhanh 25W\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/samsung/note_10_den_1.png'),
(19, 19, 'SS', '71.8 mm x 151 mm x 7.9 mm\r\n', '168 g\r\n', 'Bạc,Trắng', '256 GB\r\n', '8 GB\r\n', 'Android', '10 MP (F2.2)\r\n', '- Góc siêu rộng: 16MP (F2.2)\r\n- Góc rộng: 12MP OIS (F.15/F2.4)\r\n- Tele: 12MP OIS (F2.1)', '3500 mAh, sạc nhanh 25W\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/samsung/note_10_plus_trang.png'),
(20, 20, 'SS', '71.8 mm x 151 mm x 7.9 mm\r\n', '168 g\r\n', 'Đen,Bạc', '256 GB\r\n', '8 GB\r\n', 'Android', '10 MP (F2.2)\r\n', '- Góc siêu rộng: 16MP (F2.2)\r\n- Góc rộng: 12MP OIS (F.15/F2.4)\r\n- Tele: 12MP OIS (F2.1)', '3500 mAh, sạc nhanh 25W\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/samsung/note_lite_den.png'),
(21, 21, 'SS', '71.8 mm x 151 mm x 7.9 mm\r\n', '168 g\r\n', 'Đen,Trắng', '256 GB\r\n', '8 GB\r\n', 'Android', '10 MP (F2.2)\r\n', '- Góc siêu rộng: 16MP (F2.2)\r\n- Góc rộng: 12MP OIS (F.15/F2.4)\r\n- Tele: 12MP OIS (F2.1)', '3500 mAh, sạc nhanh 25W\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/samsung/galaxy_S10+_plus_den.png'),
(22, 22, 'SS', '71.8 mm x 151 mm x 7.9 mm\r\n', '168 g\r\n', 'Hồng,Xám', '256 GB\r\n', '8 GB\r\n', 'Android', '10 MP (F2.2)\r\n', '- Góc siêu rộng: 16MP (F2.2)\r\n- Góc rộng: 12MP OIS (F.15/F2.4)\r\n- Tele: 12MP OIS (F2.1)', '3500 mAh, sạc nhanh 25W\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/samsung/s20_hong.png'),
(23, 23, 'SS', '71.8 mm x 151 mm x 7.9 mm\r\n', '168 g\r\n', 'Đen,Xám', '256 GB\r\n', '8 GB\r\n', 'Android', '10 MP (F2.2)\r\n', '- Góc siêu rộng: 16MP (F2.2)\r\n- Góc rộng: 12MP OIS (F.15/F2.4)\r\n- Tele: 12MP OIS (F2.1)', '3500 mAh, sạc nhanh 25W\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/samsung/s20+_den.png'),
(24, 24, 'SS', '71.8 mm x 151 mm x 7.9 mm\r\n', '168 g\r\n', 'Đen,Xám', '256 GB\r\n', '8 GB\r\n', 'Android', '10 MP (F2.2)\r\n', '- Góc siêu rộng: 16MP (F2.2)\r\n- Góc rộng: 12MP OIS (F.15/F2.4)\r\n- Tele: 12MP OIS (F2.1)', '3500 mAh, sạc nhanh 25W\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/samsung/s20+_ultra_den.png'),
(25, 25, 'SS', '163.6 x 76 x 7.7 mm\r\n', '179 g\r\n', 'Bạc,Đen', '128 GB\r\n', '8 GB', 'Android', '32 MP\r\n', 'Camera chính 64MP\r\nCamera góc siêu rộng 12MP\r\n2 Camera góc rộng 5MP', '4500 mAh\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất\r\n', 'image/samsung/A71_bac.png'),
(26, 26, 'SS', '163.6 x 76 x 7.7 mm\r\n', '179 g\r\n', 'Hồng,Trắng', '128 GB\r\n', '8 GB', 'Android', '32 MP\r\n', 'Camera chính 64MP\r\nCamera góc siêu rộng 12MP\r\n2 Camera góc rộng 5MP', '4500 mAh\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất\r\n', 'image/samsung/a51_hong.png'),
(27, 27, 'SS', '163.6 x 76 x 7.7 mm\r\n', '179 g\r\n', 'Xanh,Đen', '128 GB\r\n', '8 GB', 'Android', '32 MP\r\n', 'Camera chính 64MP\r\nCamera góc siêu rộng 12MP\r\n2 Camera góc rộng 5MP', '4500 mAh\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất\r\n', 'image/samsung/a31_xanh.png'),
(28, 28, 'SS', '163.6 x 76 x 7.7 mm\r\n', '179 g\r\n', 'Đen,Gold', '128 GB\r\n', '8 GB', 'Android', '32 MP\r\n', 'Camera chính 64MP\r\nCamera góc siêu rộng 12MP\r\n2 Camera góc rộng 5MP', '4500 mAh\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất\r\n', 'image/samsung/a80_den.png'),
(29, 29, 'OP', '160 x 74.3 x 9.5 mm\r\n', '189 g\r\n', 'Xanh', '8 GB', '256 GB', 'Android\r\nXem thêm\r\n', '16 MP (f2.0)\r\n', '4 camera:\r\n- Camera chính: 48 MP (f1.7)\r\n- Camera góc rộng: 8 MP (f2.4)\r\n- Camera tele: 13 MP (f2.2)\r\n- Cảm biến đơn sắc: 2 MP (f2.4)\r\n', 'Pin chuẩn Li-Ion 4000 mAh, hỗ trợ sạc nhanh VOOC 3.0\r\n', 'Bảo Hành 12 tháng tại cửa hàng.', 'Nguyên hộp 100%.', 'image/oppo/oppo_reno2.png'),
(30, 30, 'OP', '160 x 74.3 x 9.5 mm\r\n', '189 g\r\n', 'Xanh,Đen', '8 GB', '256 GB', 'Android\r\nXem thêm\r\n', '16 MP (f2.0)\r\n', '4 camera:\r\n- Camera chính: 48 MP (f1.7)\r\n- Camera góc rộng: 8 MP (f2.4)\r\n- Camera tele: 13 MP (f2.2)\r\n- Cảm biến đơn sắc: 2 MP (f2.4)\r\n', 'Pin chuẩn Li-Ion 4000 mAh, hỗ trợ sạc nhanh VOOC 3.0\r\n', 'Bảo Hành 12 tháng tại cửa hàng.', 'Nguyên hộp 100%.', 'image/oppo/oppo_findx2_xanh.png'),
(31, 31, 'OP', '160 x 74.3 x 9.5 mm\r\n', '189 g\r\n', 'Đen,Xanh,Trắng', '8 GB', '256 GB', 'Android\r\nXem thêm\r\n', '16 MP (f2.0)\r\n', '4 camera:\r\n- Camera chính: 48 MP (f1.7)\r\n- Camera góc rộng: 8 MP (f2.4)\r\n- Camera tele: 13 MP (f2.2)\r\n- Cảm biến đơn sắc: 2 MP (f2.4)\r\n', 'Pin chuẩn Li-Ion 4000 mAh, hỗ trợ sạc nhanh VOOC 3.0\r\n', 'Bảo Hành 12 tháng tại cửa hàng.', 'Nguyên hộp 100%.', 'image/oppo/oppo_reno3_den.png'),
(32, 32, 'OP', '160 x 74.3 x 9.5 mm\r\n', '189 g\r\n', 'Đen,Trắng', '8 GB', '256 GB', 'Android\r\nXem thêm\r\n', '16 MP (f2.0)\r\n', '4 camera:\r\n- Camera chính: 48 MP (f1.7)\r\n- Camera góc rộng: 8 MP (f2.4)\r\n- Camera tele: 13 MP (f2.2)\r\n- Cảm biến đơn sắc: 2 MP (f2.4)\r\n', 'Pin chuẩn Li-Ion 4000 mAh, hỗ trợ sạc nhanh VOOC 3.0\r\n', 'Bảo Hành 12 tháng tại cửa hàng.', 'Nguyên hộp 100%.', 'image/oppo/oppo_reno3pro_den.png'),
(33, 33, 'RM', 'Đang cập nhật\r\n', 'Đang cập nhật\r\n', 'Trắng,Xanh', '128 GB', '8 GB\r\n', 'Android', '16 MP\r\n', '64 MP + 8 MP + 2 MP + 2 MP\r\n', '4000 mAh, sạc nhanh VOOC 3.0 (20W)\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/realme/realme_xt_trang.png'),
(34, 34, 'RM', 'Đang cập nhật\r\n', 'Đang cập nhật\r\n', 'Trắng,Xanh', '128 GB', '8 GB\r\n', 'Android', '16 MP\r\n', '64 MP + 8 MP + 2 MP + 2 MP\r\n', '4000 mAh, sạc nhanh VOOC 3.0 (20W)\r\n', 'Bảo hành 12 tháng tại trung tâm bảo hành Chính hãng. 1 đổi 1 trong 30 ngày nếu có lỗi nhà sản xuất.', 'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất', 'image/realme/realme_6_trang.png'),
(35, 35, 'VV', 'Dài 159.01 mm - Ngang 74.17 mm - Dày 8.54 mm', '176g', 'Xanh, Đen', '128GB', '8GB', 'Android 10', '32 MP', 'Chính 48 MP & Phụ 8 MP, 2 MP, 2 MP', '4500 mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%, chính hãng', 'image/Vivo/VivoV19Neo.png'),
(36, 36, 'VV', 'Dài 159.25 mm - Ngang 75.19 mm - Dày 8.68 mm', '188.7g', 'Đen, Trắng', '128GB', '8GB', 'Android 8.0 (Pie)', '32MP', 'Chính 48 MP & Phụ 8 MP, 2 MP, 2 MP', '4500mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%, chính hãng', 'image/Vivo/VivoS1Pro.png'),
(37, 37, 'VV', 'Dài 161.97 mm - Ngang 75.93 mm - Dày 8.54 mm', '189.5g', 'Đỏ, Xanh dương', '128GB', '6GB', 'Android 9.0 (Pie)', '32MP', 'Chính 12 MP & Phụ 8 MP, 5 MP', '4000 mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%, chính hãng', 'image/Vivo/VivoV15.png'),
(38, 38, 'VV', 'Dài 162.04 mm - Ngang 76.46 mm - Dày 9.11 mm', '197g', 'Đen, Xang dương', '128GB', '8GB', 'Android 10', '16MP', 'Chính 13 MP & Phụ 8 MP, 2 MP, 2 MP', '5000mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%,chính hãng', 'image/Vivo/VivoY50.png'),
(39, 39, 'VV', 'Dài 159.53 mm - Ngang 75.23 mm - Dày 8.13 mm', '179g', 'Đen, Xanh lam', '128GB', '6GB', 'Android 9.0 (Pie)', '32MP', 'Chính 16 MP & Phụ 8 MP, 2 MP', '4500mAp', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%', 'image/Vivo/VivoS1.png'),
(40, 40, 'VV', 'Dài 162.04 mm - Ngang 76.46 mm - Dày 9.11 mm', '197g', 'Xanh dương, Trắng', '128GB', '4GB', 'Android 10', '8MP', 'Chính 13 MP & Phụ 8 MP, 2 MP, 2 MP', '5000 mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%', 'image/Vivo/VivoY30.png'),
(41, 41, 'VV', 'Dài 162.15 mm - Ngang 76.47 mm - Dày 8.89 mm', '193g', 'Đen, Trắng', '128GB', '6GB', 'Android 9.0 (Pie)', '16MP', 'Chính 16 MP & Phụ 8 MP, 2 MP', '5000mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%, chính hãng', 'image/Vivo/VivoY19.png'),
(43, 43, 'HW', 'Dài 158.2 mm - Ngang 72.6 mm - Dày 9.0 mm', '209g', 'Xanh dương, Bạc', '256GB', '8GB', 'MUI 10 (Android 10 không có Google)', 'Chính 32 MP & Phụ IR TOF 3D', 'Chính 50 MP & Phụ 40 MP,12 MP, TOF 3D', '4200mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%', 'image/Huawei/HuaweiP40.png'),
(44, 44, 'HW', 'Dài 158.1 mm - Ngang 73.1 mm - Dày 8.8 mm', '198g', 'Bạc', '256GB', '8GB', 'EMUI 10 (Android 10 không có Google)', 'Chính 32 MP & Phụ TOF 3D', 'Chính 40 MP & Phụ 40 MP, 8 MP, TOF 3D', '4500 mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%', 'image/Huawei/HuaweiMate30.pngưư'),
(45, 45, 'HW', 'Dài 148.9 mm - Ngang 71.1 mm - Dày 8.5 mm', '175g', 'Xanh dương, Bạc', '128GB', '8GB', 'EMUI 10 (Android 10 không có Google)', 'Chính 32 MP & Phụ IR TOF 3D', 'Chính 50 MP & Phụ 16 MP, 8 MP', '3800mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%', 'image/Huawei/HuaweiP40.png'),
(46, 46, 'HW', 'Dài 154.25 mm - Ngang 73.97 mm - Dày 7.87 mm', '174g', 'Xanh lá, Xanh dương', '128GB', '8GB', 'Android 9.0 (Pie)', '32MP', 'Chính 48 MP & Phụ 16 MP, 2 MP, 2 MP', '3750mAh', 'Bảo hành chính hãng 12 tháng tại trung tâm bảo hành', 'Máy mới 100%', 'image/Huawei/HuaweiNove5T.png'),
(47, 47, 'HW', 'sad', 'asd', 'sad', 'asd', 'sad', 'sad', 'sad', 'asd', 'asd', 'asd', 'sad', 'C:/Users/Administrator/tải xuống.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi tiết đơn hàng`
--

DROP TABLE IF EXISTS `chi tiết đơn hàng`;
CREATE TABLE IF NOT EXISTS `chi tiết đơn hàng` (
  `mã đơn hàng` int(11) NOT NULL,
  `mã sản phẩm` int(11) NOT NULL,
  `số lượng` int(2) NOT NULL,
  `Tổng tiền` int(11) NOT NULL,
  `tình trạng đơn hàng` int(10) NOT NULL,
  PRIMARY KEY (`mã đơn hàng`,`mã sản phẩm`),
  KEY `mã sản phẩm` (`mã sản phẩm`),
  KEY `mã đơn hàng` (`mã đơn hàng`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chi tiết đơn hàng`
--

INSERT INTO `chi tiết đơn hàng` (`mã đơn hàng`, `mã sản phẩm`, `số lượng`, `Tổng tiền`, `tình trạng đơn hàng`) VALUES
(1, 1, 10, 43213123, 1),
(1, 32, 1, 36990000, 1),
(2, 43, 2, 36990000, 1),
(3, 25, 1, 5990000, 0),
(4, 38, 1, 5990000, 0),
(5, 46, 1, 40990000, 0),
(6, 7, 1, 33490000, 0),
(7, 12, 1, 28990000, 0),
(7, 16, 1, 17990000, 0),
(8, 15, 1, 25990000, 1),
(8, 16, 10, 17990000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chương trình khuyến mãi`
--

DROP TABLE IF EXISTS `chương trình khuyến mãi`;
CREATE TABLE IF NOT EXISTS `chương trình khuyến mãi` (
  `mã giảm giá` int(11) NOT NULL AUTO_INCREMENT,
  `ngày bắt đầu` varchar(35) NOT NULL,
  `ngày kết thúc` varchar(35) NOT NULL,
  `Loại chương trình` varchar(255) NOT NULL,
  `chi tiết chương trình` varchar(255) NOT NULL,
  PRIMARY KEY (`mã giảm giá`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danh mục`
--

DROP TABLE IF EXISTS `danh mục`;
CREATE TABLE IF NOT EXISTS `danh mục` (
  `Mã danh mục` char(255) NOT NULL,
  `Tên Danh mục` varchar(255) NOT NULL,
  PRIMARY KEY (`Mã danh mục`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `danh mục`
--

INSERT INTO `danh mục` (`Mã danh mục`, `Tên Danh mục`) VALUES
('HW', 'Huawei'),
('IP', 'iphone'),
('OP', 'Oppo'),
('RM', 'Realme'),
('SS', 'Samsung'),
('VV', 'Vivo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `maKh` int(15) NOT NULL,
  `tenKH` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `birthDate` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `maGiamGia` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`maKh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`maKh`, `tenKH`, `gender`, `CMND`, `sdt`, `birthDate`, `maGiamGia`, `status`) VALUES
(1, 'Lê Hữu Nhật', 'Nam', '21286588625', '0902777586', '07/12/1997', '', 0),
(2, 'Lê Thị Hải Yến', 'Nữ', '21587569852', '0987524665', '10/06/2000', '', 0),
(3, 'Nguyễn Thị Kim Vỹ', 'Nữ', '21245842258', '0978542531', '24/12/1999', '', 0),
(4, 'Trần Văn Chánh', 'Nam', '21258845823', '0965781223', '05/09/1995', '', 0),
(5, 'Nguyễn Văn Cường', 'Nam', '2548525545', '095648723', '14/06/1993', '', 0),
(6, 'Trần Hải', 'Nam', '2564873128', '07646525652', '09/05/1995', '', 0),
(7, 'Nguyễn Hồng Mỹ', 'Nữ', '2568754551', '0756942351', '23/09/2000', '', 0),
(8, 'Nguyễn Hà Phương', 'Nữ', '2562485555', '0359565545', '28/02/1994', '', 0),
(9, 'Lê Trung Quân', 'Nam', '26842841252', '254689421', '06/03/1997', '', 0),
(10, 'bao', 'Nam', '213213214', '0837574301', '31/08/2000', '', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNCC` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Fax` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SDT`, `Fax`) VALUES
('NCC1', 'Cty Samsung', 'TP HCM', '0123456789', '4598-8789-8789-7897'),
('NCC2', 'Cty Thương Mại Công Nghệ', 'Hà Nội', '0120728815', '3672-1782-3923-6091'),
('NCC3', 'Cty Di Động Trường Sơn', 'TP HCM', '0703192738', '2364-2974-2384-2394'),
('NCC4', 'Cty Viễn Thông Thành Đạt', 'TP HCM', '0501239237', '9823-6738-6739-6766'),
('NCC5', 'Thế Giới Công Nghệ', 'Bình Dương', '0801729329', '1830-7288-8900-7712'),
('NCC6', 'Cty TNHH Hoàng Bá', 'Long An', '0303676818', '7623-9812-3876-2834'),
('NCC7', 'Cty Di Động Thành Tiến', 'Hà Nội', '0989140736', '1873-1738-8736-4761'),
('NCC8', 'Cty Toàn Thắng', 'TP HCM', '0120628918', '8127-9382-1974-2983');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `maNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `birthDate` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `chucvu` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ngayvaolam` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `roleID` int(3) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`maNV`),
  KEY `roleID` (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`maNV`, `tenNV`, `gender`, `birthDate`, `sdt`, `CMND`, `chucvu`, `ngayvaolam`, `roleID`, `status`) VALUES
('admin', 'Dương Ngọc Bảo', 'Nam', '31/08/2000', '0837574301', '215515150', 'ADMIN', '21/06/2020', 0, 0),
('NV_001', 'Dương Ngọc Bảo', 'Nam', '05/05/1997', '0902777586', '025887101', 'Sếp Tổng', '07/05/2014', 2, 0),
('NV_002', 'Nguyễn Văn Tèo', 'Nam', '06/05/1999', '0902777589', '025887102', 'Quản lí khu C', '08/05/2014', 4, 0),
('NV_003', 'Nguyễn Văn A', 'Nữ', '07/05/1999', '0902777587', '025887103', 'Tiếp tân khu B', '10/06/2014', 0, 0),
('NV_004', 'Cẩm Lan Sục', 'Nữ', '08/05/1999', '0902777588', '025887104', 'Tiếp tân khu A', '11/02/2014', 0, 0),
('NV_005', 'Ngô Bá Khá', 'Nam', '09/05/1999', '0902777590', '025887105', 'Bảo Vệ khu A', '10/10/2015', 0, 0),
('NV_006', 'Trần Thế Bảo', 'Nam', '10/05/1999', '0902777591', '025887106', 'Quản Lí khu A', '07/03/2013', 0, 0),
('NV_007', 'Phạm Nguyễn Minh Huy', 'Nam', '11/05/1999', '0902777592', '025887107', 'Quản Lí khu B', '07/05/2015', 1, 0),
('NV_008', 'Đặng Văn Linh', 'Nam', '12/05/1999', '0902777593', '025887108', 'Giám Sát Viên', '07/04/2016', 0, 0),
('NV_009', 'Lệnh Hồ Xung', 'Nam', '13/05/1999', '0902777594', '025887109', 'Bảo Vệ khu B', '07/11/2014', 3, 0),
('NV_11', 'sadsa', 'Nam', '03/04/1951', '21312312', '213213132', 'sd', '02/02/1951', 4, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

DROP TABLE IF EXISTS `phanquyen`;
CREATE TABLE IF NOT EXISTS `phanquyen` (
  `roleID` int(3) NOT NULL,
  `tenQuyen` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `chiTiet` varchar(100) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`roleID`, `tenQuyen`, `chiTiet`) VALUES
(0, 'Admin-root', 'banHang nhapHang sanPham theLoai hoaDon nhanVien khachHang phieuNhap NCC taiKhoan phanQuyen'),
(1, 'Admin', 'banHang nhapHang sanPham theLoai hoaDon nhanVien khachHang phieuNhap NCC'),
(2, 'Manager', 'banHang nhapHang sanPham theLoai hoaDon'),
(3, 'Employee', 'banHang nhapHang sanPham theLoai hoaDon'),
(4, 'Lao công', 'banHang nhapHang sanPham theLoai hoaDon nhanVien khachHang phieuNhap NCC taiKhoan phanQuyen');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
CREATE TABLE IF NOT EXISTS `phieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayNhap` date NOT NULL,
  `GioNhap` time NOT NULL,
  `TongTien` float NOT NULL,
  PRIMARY KEY (`MaPN`),
  KEY `MaNCC` (`MaNCC`),
  KEY `MaNV` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`, `GioNhap`, `TongTien`) VALUES
('PN1', 'NCC2', 'NV1', '2019-04-24', '01:25:08', 296),
('PN10', 'NCC1', 'admin', '2020-06-23', '18:14:45', 24990000),
('PN11', 'NCC1', 'NV_001', '2020-06-23', '18:27:31', 50480000),
('PN12', 'NCC1', 'admin', '2020-06-23', '18:32:09', 74470000),
('PN2', 'NCC3', 'NV1', '2019-04-24', '01:25:23', 276.5),
('PN3', 'NCC5', 'NV12', '2019-04-25', '17:06:52', 100),
('PN4', 'NCC4', 'NV12', '2019-04-26', '02:51:18', 48.8),
('PN5', 'NCC5', 'NV12', '2019-04-26', '17:54:01', 46.9),
('PN6', 'NCC8', 'NV12', '2019-04-26', '17:58:26', 106.9),
('PN7', 'NCC6', 'NV12', '2019-05-01', '14:15:27', 1190),
('PN8', 'NCC1', 'NV12', '2019-05-10', '11:19:10', 119),
('PN9', 'NCC2', 'NV12', '2019-05-10', '11:19:53', 200);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sản phẩm`
--

DROP TABLE IF EXISTS `sản phẩm`;
CREATE TABLE IF NOT EXISTS `sản phẩm` (
  `Mã sản phẩm` int(11) NOT NULL,
  `Tên điện thoại` varchar(255) NOT NULL,
  `Mô tả` varchar(255) NOT NULL,
  `Giá cả` int(11) NOT NULL,
  `Số lượng` int(11) NOT NULL,
  PRIMARY KEY (`Mã sản phẩm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sản phẩm`
--

INSERT INTO `sản phẩm` (`Mã sản phẩm`, `Tên điện thoại`, `Mô tả`, `Giá cả`, `Số lượng`) VALUES
(1, 'iPhone 11 64GB', 'iPhone 11 chính hãng VN/A – Chiếc điện thoại nhiều màu sắc, camera nâng cấp\r\n\r\n', 20490000, 10),
(2, 'iPhone 11 128GB', 'iPhone 11 chính hãng VN/A – Chiếc điện thoại nhiều màu sắc, camera nâng cấp\r\n\r\n', 22490000, 10),
(3, 'iPhone 11 256GB', 'iPhone 11 chính hãng VN/A – Chiếc điện thoại nhiều màu sắc, camera nâng cấp\r\n\r\n', 24490000, 10),
(4, 'iPhone 11 Pro', 'iPhone 11 Pro - Siêu phẩm 3 camera chụp ảnh chuyên nghiệp\r\n', 30490000, 10),
(5, 'iPhone 11 Pro 256GB', 'iPhone 11 Pro - Siêu phẩm 3 camera chụp ảnh chuyên nghiệp.\r\nThiết kế thép nguyên khối với mặt lưng kính mờ và màn hình 5.8 inches sắc nét.\r\n', 32490000, 10),
(6, 'iPhone 11 Pro 512GB', 'iPhone 11 Pro - Siêu phẩm 3 camera chụp ảnh chuyên nghiệp.\r Thiết kế thép nguyên khối với mặt lưng kính mờ và màn hình 5.8 inches sắc nét.\r ', 47490000, 7),
(7, 'iPhone 11 Pro Max', 'Chiếc iPhone mạnh mẽ nhất, lớn nhất, thời lượng pin tốt nhất đã xuất hiện. iPhone 11 Pro Max chắc chắn là chiếc điện thoại mà ai cũng ao ước khi sở hữu những tính năng xuất sắc nhất, đặc biệt là camera và pin.', 33490000, 10),
(8, 'iPhone 11 Pro Max 256GB', 'Chiếc iPhone mạnh mẽ nhất, lớn nhất, thời lượng pin tốt nhất đã xuất hiện. iPhone 11 Pro Max chắc chắn là chiếc điện thoại mà ai cũng ao ước khi sở hữu những tính năng xuất sắc nhất, đặc biệt là camera và pin.', 35490000, 7),
(9, 'iPhone 11 Pro Max 512GB', 'Chiếc iPhone mạnh mẽ nhất, lớn nhất, thời lượng pin tốt nhất đã xuất hiện. iPhone 11 Pro Max chắc chắn là chiếc điện thoại mà ai cũng ao ước khi sở hữu những tính năng xuất sắc nhất, đặc biệt là camera và pin.', 40490000, 10),
(10, 'iPhone XS', 'iPhone XS 64GB chính hãng VN/A là bản nâng cấp từ iPhone X, mang trong mình sức mạnh phần cứng vượt trội được tối ưu hóa bởi hệ điều hành iOS nhằm đem lại trải nghiệm mượt mà và tuyệt vời nhất cho người dùng.', 20490000, 11),
(11, 'iPhone XS 256GB', 'iPhone XS chính hãng VN/A là bản nâng cấp từ iPhone X, mang trong mình sức mạnh phần cứng vượt trội được tối ưu hóa bởi hệ điều hành iOS nhằm đem lại trải nghiệm mượt mà và tuyệt vời nhất cho người dùng.', 24990000, 12),
(12, 'iPhone XS 512GB', 'iPhone XS chính hãng VN/A là bản nâng cấp từ iPhone X, mang trong mình sức mạnh phần cứng vượt trội được tối ưu hóa bởi hệ điều hành iOS nhằm đem lại trải nghiệm mượt mà và tuyệt vời nhất cho người dùng.', 28990000, 10),
(13, 'iPhone XS Max', 'iPhone XS Max sỡ hữu những công nghệ nổi bật như chip A12 mạnh mẽ, màn hình rộng đến 6.5 inches, camera kép AI, Face ID nâng cấp cùng dung lượng bộ nhớ tối ưu.', 28990000, 11),
(14, 'iPhone XS Max 256GB', 'iPhone XS Max sỡ hữu những công nghệ nổi bật như chip A12 mạnh mẽ, màn hình rộng đến 6.5 inches, camera kép AI, Face ID nâng cấp cùng dung lượng bộ nhớ tối ưu.', 24490000, 11),
(15, 'iPhone XS Max 512GB', 'iPhone XS Max sỡ hữu những công nghệ nổi bật như chip A12 mạnh mẽ, màn hình rộng đến 6.5 inches, camera kép AI, Face ID nâng cấp cùng dung lượng bộ nhớ tối ưu.', 25990000, 11),
(16, 'iPhone X', 'Sản phẩm kỷ niệm 10 năm ra mắt của Apple nên iPhone X 64GB có sự thay đổi so với bộ đôi iPhone 8, 8 Plus trước đó từ tính năng đến thiết kế khiến nhiều người dùng smartphone khao khát.', 17990000, 10),
(17, 'iPhone X 256GB', 'Sản phẩm kỷ niệm 10 năm ra mắt của Apple nên iPhone X 64GB có sự thay đổi so với bộ đôi iPhone 8, 8 Plus trước đó từ tính năng đến thiết kế khiến nhiều người dùng smartphone khao khát.', 19490000, 10),
(18, 'Samsung Galaxy Note 10', 'Samsung Galaxy Note 10 mang phong cách thiết kế vuông vắn, kích thước 71.8 x 151 mm và độ mỏng chỉ 7.9mm. Khả năng bắt sáng tạo nên ánh quang cùng lớp kính cường lực Gorilla 6 mang đến sự bảo vệ vừng chắc cho Samsung Galaxy Note 10.', 17790000, 10),
(19, 'Samsung Galaxy Note 10 Plus', 'Samsung Galaxy Note 10 mang phong cách thiết kế vuông vắn, kích thước 71.8 x 151 mm và độ mỏng chỉ 7.9mm. Khả năng bắt sáng tạo nên ánh quang cùng lớp kính cường lực Gorilla 6 mang đến sự bảo vệ vừng chắc cho Samsung Galaxy Note 10.', 20790000, 10),
(20, 'Samsung Galaxy Note 10 Lite', 'Samsung Galaxy Note 10 mang phong cách thiết kế vuông vắn, kích thước 71.8 x 151 mm và độ mỏng chỉ 7.9mm. Khả năng bắt sáng tạo nên ánh quang cùng lớp kính cường lực Gorilla 6 mang đến sự bảo vệ vừng chắc cho Samsung Galaxy Note 10.', 12490000, 10),
(21, 'Samsung Galaxy S10+ Plus', 'Thiết kế thiên hướng Note 9, kiểu màn hình Infinity-O độc đáo. Tai thỏ, cũng như phần viền dày đã biến mất, thay vào đó là một ‘nốt ruồi’ chứa 2 camera selfie nằm ở góc phải màn hình.', 13990000, 10),
(22, 'Samsung Galaxy S20', 'Với màn hình 120Hz Super Amoled có kích thước lớn 6,2 inch, tỉ lệ khung hình 20:9. Nhờ đó Galaxy S20 cho khả năng hiển thị lớn với các chi tiết mịn màng, thao tác nhạy.', 18490000, 10),
(23, 'Samsung Galaxy S20+ Plus', 'Với màn hình 120Hz Super Amoled có kích thước lớn 6,2 inch, tỉ lệ khung hình 20:9. Nhờ đó Galaxy S20 cho khả năng hiển thị lớn với các chi tiết mịn màng, thao tác nhạy.', 20990000, 10),
(24, 'Samsung Galaxy S20 Ultra', 'Với màn hình 120Hz Super Amoled có kích thước lớn 6,2 inch, tỉ lệ khung hình 20:9. Nhờ đó Galaxy S20 cho khả năng hiển thị lớn với các chi tiết mịn màng, thao tác nhạy.', 23790000, 10),
(25, 'Samsung Galaxy A71', 'Galaxy A71 sở hữu màn hình Super AMOLED Plus 6,7 inch. Có độ phân giải Full HD 1080 x 2400 pixel, 393ppi. Máy cũng được trang bị đầu đọc dấu vân tay dưới màn hình giống như nhiều mẫu smartphone của Samsung đã ra mắt gần đây với tốc độ nhận diện rất nhanh.', 9790000, 10),
(26, 'Samsung Galaxy A51', 'Khác với những smartphone sử dụng chất liệu kim loại thì Galaxy A51 lại có chất liệu là nhựa. Với chất liệu này A51 sẽ có mức giá rẻ hơn nhưng vẫn vô cùng cứng cáp, bền bỉ.', 7790000, 10),
(27, 'Samsung Galaxy A31', 'Samsung A31 thuộc dòng Galaxy A sở hữu thiết kế nguyên khối cứng cáp và bền bỉ. Các chi tiết trên máy được nhà sản xuất hoàn thiện một cách cực kì tỉ mỉ và chau chuốt, các góc cạnh được bo tròn êm ái cho người dùng cầm nắm chắc tay hơn.', 6490000, 10),
(28, 'Samsung Galaxy A80', 'Galaxy A80 – thiết kế màn hình không viền full HD+ cho khả năng hiển thị tốt\r\nKhông còn màn hình tai thỏ, màn hình giọt nước này đục lỗ mà một màn hình tràn viền hoàn toàn, không còn sự xuất hiện của camera.', 8990000, 10),
(29, 'Oppo Reno 2', 'Oppo Reno 2 sở hữu 4 camera sau zoom 20x cùng camera selfie “vây cá mập” độc đáo\r\nDường như, camera selfie “vây cá mập” đã là đặc trưng và đặc điểm nhận diện của dòng Oppo Reno, được thiết kế bởi một hình tam giác giống như chiếc vây cá mập.', 7490000, 10),
(30, 'Oppo Find X2', 'Find X2 có thiết kế chuyển màu nổi bật, cho cảm giác cực kì nhẹ nhàng\r\nOppo Find X2 nổi bật với mặt sau làm từ chất liệu nhựa nhưng vẫn thể hiện lên tính sang trọng của máy bởi phần màu sắc. Màu sắc gradient ấn tượng xanh đam mê.', 20790000, 10),
(31, 'Oppo Reno 3', 'Thiết kế nguyên khối tinh tế mỏng và nhẹ hơn với các màu sắc tự nhiên\r\nOppo Reno 3 sở hữu thiết kế nguyên khối tinh tế với kích thước 160.2 x 73.3 mm và độ mỏng chỉ 7.9mm nên có trọng lượng nhẹ hơn, chỉ 170g.', 8490000, 10),
(32, 'Oppo Reno 3 Pro', 'Thiết kế nguyên khối tinh tế mỏng và nhẹ hơn với các màu sắc tự nhiên\r\nOppo Reno 3 sở hữu thiết kế nguyên khối tinh tế với kích thước 160.2 x 73.3 mm và độ mỏng chỉ 7.9mm nên có trọng lượng nhẹ hơn, chỉ 170g.', 14490000, 10),
(33, 'Realme XT', 'Mặt lưng Realme XT được làm bằng kính 3D với hiệu ứng màu sắc gradient\r\nRealme XT được hoàn thiện vô cùng cao cấp với từng đường nét được chăm chút tỉ mỉ đi kèm là một độ mỏng vừa phải giúp cho máy thích hợp để trở thành một món đồ trang sức.', 6490000, 10),
(34, 'Realme 6 8GB', 'Mặt lưng Realme XT được làm bằng kính 3D với hiệu ứng màu sắc gradient\r\nRealme XT được hoàn thiện vô cùng cao cấp với từng đường nét được chăm chút tỉ mỉ đi kèm là một độ mỏng vừa phải giúp cho máy thích hợp để trở thành một món đồ trang sức.', 6990000, 10),
(35, 'Vivo V19 Neo', 'Vivo V19 Neo có bộ camera sau Vl siêu chụp đêm.', 8590000, 10),
(36, 'Vivo S1 Pro', 'Vivo S1 Pro sở hữu ngoại hình đẹp, khó có thể chê đi kèm trang bị hấp dẫn với vân tay trong màn hình, camera selfie 32 MP đi kèm nhiều công nghệ hiện đại.', 6990000, 10),
(37, 'Vivo V15', 'Được xem là bản rút gọn của flagship Vivo V15 Pro sắp ra mắt, chiếc điện thoại Vivo V15 128GB vẫn mang trong mình nhiều nét đáng giá với thiết kế cao cấp cùng camera sefie pop-up 32 MP lạ mắt.', 5790000, 10),
(38, 'Vivo Y50', 'Vivo Y50 là chiếc điện thoại tầm trung sở hữu thiết kế hiện đại với màn hình tràn viền, cụm 4 camera đột phá, hiệu năng tốt hẹn sẽ tiếp tục trở thành một sản phẩm “ngon - bổ - rẻ” cho mọi người dùng.', 6990000, 10),
(39, 'Vivo S1', 'Vivo S1 là chiếc smartphone S series mới sở hữu thiết kế tuyệt đẹp, đi kèm hệ thống 3 camera sau, cùng giá bán khá hấp dẫn.', 5790000, 10),
(40, 'Vivo Y30', 'Vivo vừa ra mắt thêm dòng sản phẩm Vivo Y30 mới, một thiết bị sở hữu cho mình thiết kế nốt ruồi tràn viền thời thượng, cụm 4 camera sau cùng dung lượng pin lớn đáp ứng tốt nhu cầu sử dụng của đại đa số người dùng.', 4990000, 10),
(41, 'Vivo Y19', 'Vivo Y19 là chiếc smartphone tập trung mạnh vào khả năng chụp ảnh ở camera chính lẫn camera selfie với công nghệ AI, hứa hẹn sẽ nhận được sự đón nhận tới từ người dùng là những bạn trẻ năng động và cá tính.', 4490000, 10),
(43, 'Huawei P40 Pro', 'Huawei P40 Pro là một trong 3 mẫu smartphone đầu bảng năm 2020 đến từ nhà Huawei. Chiếc máy sở hữu cụm 4 camera Leica chụp ảnh và quay phim đỉnh cao, thiết kế màn hình siêu tràn ấn tượng cùng hiệu năng khủng xứng tầm flagship.', 23790000, 10),
(44, 'Huawei Mate 30 Pro', 'Huawei luôn mang tới cho người dùng sự bất ngờ với những trang bị đột phá lần đầu tiên xuất hiện trên chiếc smartphone của mình và mới đây chiếc Huawei Mate 30 Pro đã chính thức ra mắt và nó vẫn mang trong mình rất nhiều công nghệ mang tính đột phá của Hu', 21990000, 10),
(45, 'Huawei P40', 'Chiếc điện thoại cao cấp Huawei P40 mới được Huawei giới thiệu vào tháng 3/2020. Với thiết kế tinh tế, hiệu năng khủng cùng hệ thống camera ấn tượng, chiếc smartphone hứa hẹn sẽ tạo nên làn sóng mới cho thị trường điện thoại di động 2020.', 17790000, 10),
(46, 'Huawei Nova 5T', 'Huawei Nova 5T là mẫu smartphone có cấu hình mạnh mẽ, thiết kế thời trang, đánh mạnh vào khâu chụp ảnh selfie với camera 32 MP, nhưng lại có giá bán rất cạnh tranh.', 8990000, 10),
(47, 'bao', 'asd', 231, 3213);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `maKH` int(15) DEFAULT NULL,
  `MaNV` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenUser` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sdt` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loginDate` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  KEY `maKH` (`maKH`),
  KEY `MaNV` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`idUser`, `pass`, `maKH`, `MaNV`, `email`, `tenUser`, `sdt`, `loginDate`) VALUES
('123', '123', NULL, 'NV_003', NULL, NULL, NULL, '22/06/2020 22:13:33'),
('admin', 'admin', NULL, 'admin', 'duongngocbaob109@gmail.com', 'Dương Ngọc Bảo', '0837574301', '23/06/2020 22:37:22'),
('baodeptrai', 'baodeptrai', NULL, 'NV_002', NULL, NULL, NULL, '22/06/2020 21:49:03'),
('bdt', 'bdt', NULL, 'NV_001', 'abcxsd@dsad.dasd', 'Dương Ngọc Bảo', '0845454565', '23/06/2020 18:26:20'),
('customer', '123456', 1, NULL, 'sieusaopolo15@gmail.com', NULL, '0902777586', '23/06/2020 11:42:08');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `đơn hàng`
--

DROP TABLE IF EXISTS `đơn hàng`;
CREATE TABLE IF NOT EXISTS `đơn hàng` (
  `Mã đơn hàng` int(11) NOT NULL,
  `Mã người dùng` int(11) DEFAULT NULL,
  `MaNV` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tổng tiền` int(11) NOT NULL,
  `Ngày khởi tạo` varchar(35) NOT NULL,
  `gioLap` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Mã đơn hàng`),
  KEY `đơn hàng_ibfk_1` (`Mã người dùng`),
  KEY `MaNV` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `đơn hàng`
--

INSERT INTO `đơn hàng` (`Mã đơn hàng`, `Mã người dùng`, `MaNV`, `Tổng tiền`, `Ngày khởi tạo`, `gioLap`) VALUES
(1, 4, 'NV_001', 100690000, '20/06/2019', NULL),
(2, 2, NULL, 36990000, '19/6/2020', NULL),
(3, 6, NULL, 10690000, '11/05/2020', NULL),
(4, 8, NULL, 56800000, '09/05/2019', NULL),
(5, 5, NULL, 56000000, '23/05/2020', NULL),
(6, 1, NULL, 33490000, '23/06/2020', '11:42:26'),
(7, 10, 'admin', 46980000, '23/06/2020', '15:25:32'),
(8, 10, 'admin', 205890000, '23/06/2020', '17:18:44');

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sản phẩm` (`Mã sản phẩm`);

--
-- Các ràng buộc cho bảng `chi tiết khuyến mãi`
--
ALTER TABLE `chi tiết khuyến mãi`
  ADD CONSTRAINT `chi tiết khuyến mãi_ibfk_1` FOREIGN KEY (`mã giảm giá`) REFERENCES `chương trình khuyến mãi` (`mã giảm giá`),
  ADD CONSTRAINT `chi tiết khuyến mãi_ibfk_2` FOREIGN KEY (`mã sản phẩm`) REFERENCES `sản phẩm` (`Mã sản phẩm`);

--
-- Các ràng buộc cho bảng `chi tiết sản phẩm`
--
ALTER TABLE `chi tiết sản phẩm`
  ADD CONSTRAINT `Chi tiết sản phẩm_ibfk_1` FOREIGN KEY (`Mã sản phẩm`) REFERENCES `sản phẩm` (`Mã sản phẩm`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Chi tiết sản phẩm_ibfk_2` FOREIGN KEY (`Mã danh mục`) REFERENCES `danh mục` (`Mã danh mục`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chi tiết đơn hàng`
--
ALTER TABLE `chi tiết đơn hàng`
  ADD CONSTRAINT `chi tiết đơn hàng_ibfk_1` FOREIGN KEY (`mã sản phẩm`) REFERENCES `sản phẩm` (`Mã sản phẩm`),
  ADD CONSTRAINT `chi tiết đơn hàng_ibfk_2` FOREIGN KEY (`mã đơn hàng`) REFERENCES `đơn hàng` (`Mã đơn hàng`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`roleID`) REFERENCES `phanquyen` (`roleID`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`maKH`) REFERENCES `khachhang` (`maKh`),
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`maNV`);

--
-- Các ràng buộc cho bảng `đơn hàng`
--
ALTER TABLE `đơn hàng`
  ADD CONSTRAINT `đơn hàng_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`maNV`),
  ADD CONSTRAINT `đơn hàng_ibfk_2` FOREIGN KEY (`Mã người dùng`) REFERENCES `khachhang` (`maKh`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
