-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-08-2017 a las 00:17:47
-- Versión del servidor: 10.1.24-MariaDB
-- Versión de PHP: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spring`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `descripcion` mediumtext NOT NULL,
  `url` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `items`
--

INSERT INTO `items` (`id`, `nombre`, `descripcion`, `url`) VALUES
(1, ' Pepitos de crema', 'Para prepararlos tendrás que freír unos panecillos especiales para perritos y luego los rebozas en en azúcar mezclado con canela. Una vez fríos, los abres y los rellenas con una generosa cantidad de crema pastelera.', 'http://azu1.facilisimo.com/ima/i/1/c/56/gr_937217_6926751_582784.jpg'),
(2, ' Tarta de manzana', 'Con una masa quebrada cubres la base de un molde. Lo llenas con la crema pastelera y lo cubres con láminas de manzana en crudo y un poco de azúcar. Se hornea y luego se decora con unas cucharadas de mermelada de melocotón o albaricoque.', 'http://azu1.facilisimo.com/ima/i/1/c/56/gr_937217_6926764_108838.jpg'),
(3, 'Bandeja de pasteles', 'Alaska de fresa, barquita de frambuesa, bocadito de nata, bomba de naranja, canutillo de crema, capuchina, disco de chocolate, eclair de caramelo.', 'http://www.pasteleria-mallorca.com/ka/apps/mallorca/assets/products/pasteles.jpg'),
(4, 'TARTA TRES CHOCOLATES', 'Bizcocho de chocolate con mousse de chocolate blanco, chocolate de leche y chocolate negro con un baño de chocolate negro brillante.', 'http://www.pasteleria-mallorca.com/ka/apps/mallorca/assets/products/10601.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
