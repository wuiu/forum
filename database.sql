CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `account_id` bigint(20) DEFAULT NULL,
                        `login` varchar(255) DEFAULT NULL,
                        `token` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `avatar_url` varchar(255) DEFAULT NULL,
                        `url` varchar(255) DEFAULT NULL,
                        `html_url` varchar(255) DEFAULT NULL,
                        `create_time` bigint(20) DEFAULT NULL,
                        `last_update_time` bigint(20) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;