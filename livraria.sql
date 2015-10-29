-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Oct 29, 2015 at 02:19 PM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `livraria`
--

-- --------------------------------------------------------

--
-- Table structure for table `compra`
--

CREATE TABLE `compra` (
  `usuario_id` bigint(20) NOT NULL,
  `livro_id` bigint(20) NOT NULL,
  `quantidade` int(11) NOT NULL DEFAULT '1',
  `data_venda` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `editora`
--

CREATE TABLE `editora` (
`id` bigint(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `editora`
--

INSERT INTO `editora` (`id`, `nome`, `endereco`, `cidade`) VALUES
(1, 'Editora Nova', 'Av. Getúlio Vargas, 333.', 'Petrópolis'),
(2, 'Editora Campus', 'Av. Venceslau Brás, 54. Botafogo', 'Rio de Janeiro'),
(3, 'Livros Lumiar ', 'Rua Augusta, 330', 'São Paulo');

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

CREATE TABLE `genero` (
`id` bigint(20) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `genero`
--

INSERT INTO `genero` (`id`, `nome`) VALUES
(1, 'Infanto-Juvenil'),
(2, 'Romance'),
(3, 'Terror'),
(4, 'Ficção científica');

-- --------------------------------------------------------

--
-- Table structure for table `livro`
--

CREATE TABLE `livro` (
`id` bigint(20) NOT NULL,
  `isbn` varchar(15) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `resumo` varchar(45) DEFAULT NULL,
  `autor` varchar(200) DEFAULT NULL,
  `preco` decimal(5,2) NOT NULL DEFAULT '0.00',
  `editora_id` bigint(20) NOT NULL,
  `genero_id` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `livro`
--

INSERT INTO `livro` (`id`, `isbn`, `titulo`, `resumo`, `autor`, `preco`, `editora_id`, `genero_id`) VALUES
(1, '222.222', 'Poços de Visconde', 'Lorem ipsum', 'Monteiro Lobato', 30.00, 1, 1),
(2, '1212.21', 'Capitães de Areia', 'Lorem ipsum', 'Jorge Amado', 35.00, 1, 1),
(3, '1111', 'Dona flor e seus dois maridos', 'lorem ipsum', 'Luciano', 40.00, 2, 2),
(4, '123123', 'titulo qualquer', 'asdfasdf asdfas fasdfa sds', 'Roberto', 33.00, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
`id` bigint(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `perfil` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `endereco`, `perfil`) VALUES
(1, 'Teste', 't', 't', 'Rua Teodoro da Silva, 751. Apto 703-2.', 'Administrador'),
(2, 'Ana', 'u', 'u', 'Rua 1', 'Usuário');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
 ADD PRIMARY KEY (`usuario_id`,`livro_id`), ADD KEY `fk_usuario_has_livro_livro1_idx` (`livro_id`), ADD KEY `fk_usuario_has_livro_usuario1_idx` (`usuario_id`);

--
-- Indexes for table `editora`
--
ALTER TABLE `editora`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genero`
--
ALTER TABLE `genero`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `livro`
--
ALTER TABLE `livro`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_livro_editora_idx` (`editora_id`), ADD KEY `fk_livro_genero1_idx` (`genero_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `editora`
--
ALTER TABLE `editora`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `genero`
--
ALTER TABLE `genero`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `livro`
--
ALTER TABLE `livro`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `compra`
--
ALTER TABLE `compra`
ADD CONSTRAINT `fk_usuario_has_livro_livro1` FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_usuario_has_livro_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `livro`
--
ALTER TABLE `livro`
ADD CONSTRAINT `fk_livro_editora` FOREIGN KEY (`editora_id`) REFERENCES `editora` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_livro_genero1` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

