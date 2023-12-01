-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2023 at 12:03 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `super_market`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(255) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `code_bar` varchar(255) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `product_name`, `code_bar`, `price`) VALUES
(3, 'S', 's', 33),
(4, 'D', 'd', 55),
(9, 'koka kola', '5+65+65+5+65+', 55),
(10, 'banan', 'qsfqsfqsf', 666),
(11, 'halwa', 'qfdqsfqsfq', 1000),
(12, 'tchina', 'qsfqsfqsfqsfqsf', 3),
(13, 'kiwi', 'qsfqsfqsfqsfqsfq', 200000000000),
(14, 'hrisa', 'qsfdqsfq', 55),
(15, 'n', 'nn', 546),
(16, 'n', 'n', 6),
(17, 'b', 'b', 5),
(18, 'qsfdfqs', 'sfqqsfq', 20);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `product` varchar(255) NOT NULL,
  `code_bar` mediumtext NOT NULL,
  `price` float NOT NULL,
  `sum` float NOT NULL,
  `qte` float NOT NULL,
  `date` mediumtext NOT NULL,
  `time` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `username`, `product`, `code_bar`, `price`, `sum`, `qte`, `date`, `time`) VALUES
(590, 's', '5', '555', 55, 555, 55, '2023-11-16', '555'),
(591, '5', '444', '44', 0, 0, 0, '2023-11-16', '6'),
(592, '77', '77', '77', 777, 77, 77, '777', '777'),
(593, '20', '20', '20', 200, 20, 20, '20', '20'),
(594, '99999', '99999', '9999', 9999, 9999, 9999, '99999', '99999'),
(595, '5', '5', '5', 10, 20, 1, '55', '5'),
(596, '5', '66', '66', 666, 66, 6, '55', '5'),
(597, 'ddd', 'slfjd', 'dld', 10, 200, 20, '2023-11-17', '23:38:32'),
(598, 'ddd', 'slfjd', 'dld', 10, 210, 21, '2023-11-17', '23:38:32'),
(599, 'ddd', 'slfjd', 'dld', 10, 200, 20, '2023-11-18', '12:44:29'),
(600, 'ddd', 'slfjd', 'dld', 10, 210, 21, '2023-11-18', '12:44:29'),
(601, 'ddd', 'D', 'd', 55, 55, 1, '2023-11-18', '12:44:29'),
(602, 'a', 'kiwi', 'qsfqsfqsfqsfqsfq', 200000000000, 200000000000, 1, '2023-12-01', '11:41:41'),
(603, 'a', 'kiwi', 'qsfqsfqsfqsfqsfq', 200000000000, 200000000000, 1, '2023-12-01', '11:41:41'),
(604, 'a', 'kiwi', 'qsfqsfqsfqsfqsfq', 200000000000, 200000000000, 1, '2023-12-01', '11:41:41'),
(605, 'a', 'kiwi', 'qsfqsfqsfqsfqsfq', 200000000000, 200000000000, 1, '2023-12-01', '11:41:41'),
(606, 'a', 'kiwi', 'qsfqsfqsfqsfqsfq', 200000000000, 200000000000, 1, '2023-12-01', '11:41:41'),
(607, 'a', 'kiwi', 'qsfqsfqsfqsfqsfq', 200000000000, 200000000000, 1, '2023-12-01', '11:41:41');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `root` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `root`) VALUES
(86, 'a', 'a', 1),
(87, 'c', 'c', 0),
(88, 'ff', 'ff', 0),
(90, 'ddd', 'ddd', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code_bar` (`code_bar`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `sales` ADD FULLTEXT KEY `product` (`product`);
ALTER TABLE `sales` ADD FULLTEXT KEY `codeBar` (`code_bar`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=608;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
