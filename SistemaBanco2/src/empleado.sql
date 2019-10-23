-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2019 a las 05:49:53
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `fecha_nac` date NOT NULL,
  `nss` bigint(20) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `sexo` varchar(2) NOT NULL,
  `sueldo` int(11) NOT NULL,
  `horario` varchar(8) NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_salida` time NOT NULL,
  `codigo` int(11) NOT NULL,
  `nip` varchar(5) NOT NULL,
  `usuario` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`nombre`, `apellido`, `telefono`, `domicilio`, `fecha_nac`, `nss`, `correo`, `sexo`, `sueldo`, `horario`, `hora_entrada`, `hora_salida`, `codigo`, `nip`, `usuario`) VALUES
('Mario', 'Morales', 3751083173, 'Libertad 34', '1999-08-31', 1234567890, 'mamg@gmail.com', 'M', 15000, 'LIV', '08:00:00', '04:00:00', 1, '123', 'ADMIN'),
('Karen', 'Jaramillo', 1233211232, 'Revolucion 90', '1999-06-24', 2345678901, 'karenj@gmail.com', 'F', 13000, 'MJS', '08:00:00', '16:00:00', 2, '321', '1521'),
('Johan', 'Vaca', 3311233212, 'Colon 21', '1999-10-10', 3456789012, 'gohan@hotmail.com', 'M', 10000, 'VSD', '12:00:00', '20:00:00', 3, '345', '1817'),
('Alejandro', 'Perez', 3312213425, 'Olimpica 12', '1986-09-17', 4567890123, 'alpe@gmail.com', 'M', 12000, 'LJS', '10:00:00', '18:00:00', 4, '456', '8956'),
('Camilo', 'Martinez', 3312213427, 'Revolucion 32', '1996-12-07', 5678901234, 'cama@gmail.com', 'M', 11000, 'ISD', '12:00:00', '20:00:00', 5, '678', '1857'),
('Julia', 'Mendoza', 3751083274, 'Eucalipto 11', '1989-08-20', 6789012345, 'juma@hotmail.com', 'F', 18000, 'LIJSD', '11:00:00', '19:00:00', 6, '123', '4532'),
('Karla', 'Sanchez', 3354327822, 'Patria 55', '1990-08-13', 7543221656, 'kasa@gmail.com', 'F', 15000, 'MIV', '10:00:00', '18:00:00', 7, '436', '5676'),
('Omar', 'Casallas', 3312215423, 'Aguilas 34', '1989-10-10', 8543274217, 'omca@gmail.com', 'M', 19000, 'LMJS', '12:00:00', '18:00:00', 8, '462', '7394'),
('Marisol', 'Larios', 3367328921, 'Miravalle 134', '1988-12-17', 9432464360, 'mala@gmail.com', 'F', 17000, 'LMI', '13:00:00', '21:00:00', 9, '573', '2891'),
('Maria', 'Reyes', 3378429374, 'Mirasol 567', '1992-05-06', 432452751, 'mare@gmail.com', 'F', 18000, 'VSD', '11:00:00', '19:00:00', 10, '431', '4782');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
