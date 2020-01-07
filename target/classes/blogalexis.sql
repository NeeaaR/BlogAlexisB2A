-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 05 jan. 2020 à 22:52
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `blogalexis`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_article` int(11) NOT NULL AUTO_INCREMENT,
  `auteur` varchar(255) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `texte` text NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_article`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `auteur`, `titre`, `description`, `texte`, `date`) VALUES
(1, 'Alexis', 'Donald Trump menace l’Iran de frapper 52 sites « de très haut niveau »', '« Viser des sites culturels est un crime de guerre », a mis en garde le ministre des affaires étrangères iranien, alors que les Américains disent avoir identifié des cibles « très importantes pour la culture iranienne ».', 'Le président Donald Trump a averti, samedi 4 janvier, Téhéran que les Etats-Unis ont identifié 52 sites en Iran et les frapperont « très rapidement et très durement » si la République islamique attaque du personnel ou des objectifs américains. Certains de ces sites iraniens « sont de très haut niveau et très importants pour l’Iran et pour la culture iranienne », a précisé Donald Trump dans un tweet. « Les Etats-Unis ne veulent plus de menaces ! », a-t-il prévenu.\r\n\r\nM. Trump a souligné que le chiffre de 52 correspondait au nombre d’Américains qui avaient été retenus en otages pendant plus d’un an à partir de la fin de 1979 à l’ambassade des Etats-Unis à Téhéran.', '2020-01-01'),
(2, 'Daemon', 'Nucléaire : Téhéran s’affranchit des limites à l’enrichissement d’uranium', 'L’Iran va toutefois continuer de coopérer avec l’Agence internationale de l’énergie atomique et pourrait revenir sur ces mesures si les Etats-Unis lèvent leurs sanctions.', 'L’Iran a annoncé dimanche 5 janvier qu’il s’affranchissait davantage de l’accord de 2015 sur son programme nucléaire, en ne s’imposant plus de limites pour l’enrichissement d’uranium.\r\n\r\nD’après un porte-parole du gouvernement, cité par la télévision d’Etat, Téhéran ne va plus respecter les limites fixées dans cet accord au nombre de centrifugeuses qu’il a le droit d’utiliser. Cela signifie qu’il n’y aura plus de plafond à ses capacités d’enrichissement d’uranium, ni au degré d’enrichissement de l’uranium ou encore à ses activités de recherche et développement dans le domaine nucléaire.', '2020-01-02'),
(3, 'Alexis', 'Welcome at Home', 'BIENVENUE A LA MAISON \r\nEn dépit de son divorce, Jeff Bezos demeure l?homme le plus riche du monde. Et sans doute l?un des plus pingres, malgré ses 114 milliards de dollars (103 milliards d?euros), selon le classement 2019 du magazine Forbes. Le fondateur d?Amazon, 56 ans, n?est-il pas l?un des rares à ne pas avoir signé l?appel lancé en 2010 par son homologue de Microsoft, Bill Gates, et l?investisseur Warren Buffet, incitant les milliardaires à donner la moitié de leur fortune à des ?uvres philanthropiques ? Son ex-femme l?a fait, tout comme quelque 200 autres ultra-riches de la planète. Mais pas Jeff Bezos lui-même. Tout en saluant l?initiative de son ancienne compagne (« Je suis fier d?elle »), il n?a pas semblé savoir quoi faire de ses milliards.', 'En dépit de son divorce, Jeff Bezos demeure l?homme le plus riche du monde. Et sans doute l?un des plus pingres, malgré ses 114 milliards de dollars (103 milliards d?euros), selon le classement 2019 du magazine Forbes. Le fondateur d?Amazon, 56 ans, n?est-il pas l?un des rares à ne pas avoir signé l?appel lancé en 2010 par son homologue de Microsoft, Bill Gates, et l?investisseur Warren Buffet, incitant les milliardaires à donner la moitié de leur fortune à des ?uvres philanthropiques ? Son ex-femme l?a fait, tout comme quelque 200 autres ultra-riches de la planète. Mais pas Jeff Bezos lui-même. Tout en saluant l?initiative de son ancienne compagne (« Je suis fier d?elle »), il n?a pas semblé savoir quoi faire de ses milliards.En dépit de son divorce, Jeff Bezos demeure l?homme le plus riche du monde. Et sans doute l?un des plus pingres, malgré ses 114 milliards de dollars (103 milliards d?euros), selon le classement 2019 du magazine Forbes. Le fondateur d?Amazon, 56 ans, n?est-il pas l?un des rares à ne pas avoir signé l?appel lancé en 2010 par son homologue de Microsoft, Bill Gates, et l?investisseur Warren Buffet, incitant les milliardaires à donner la moitié de leur fortune à des ?uvres philanthropiques ? Son ex-femme l?a fait, tout comme quelque 200 autres ultra-riches de la planète. Mais pas Jeff Bezos lui-même. Tout en saluant l?initiative de son ancienne compagne (« Je suis fier d?elle »), il n?a pas semblé savoir quoi faire de ses milliards.', '2020-01-05');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_commentaire` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` text NOT NULL,
  `id_article` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_commentaire`),
  KEY `FK_article` (`id_article`),
  KEY `FK_utilisateur` (`id_utilisateur`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `commentaire`, `id_article`, `id_utilisateur`, `date`) VALUES
(1, 'Super article ! merci', 1, 1, '2020-01-01'),
(2, 'J\'ai adoré bravo !', 1, 4, '2020-01-02'),
(4, 'Très intéressant ', 2, 4, '2020-01-04');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `utilisateur` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `utilisateur`, `mdp`) VALUES
(1, 'Alexis', 'alexis123'),
(4, 'Guillaume', 'guillauem123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
