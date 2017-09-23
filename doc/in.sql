INSERT INTO `online`.`foot_site` (`id`, `name`, `start_time`, `match_name`) VALUES ('1', '皇马VS巴萨', '2017-10-1 18:00:00', '西甲');
INSERT INTO `online`.`foot_site` (`id`, `name`, `start_time`, `match_name`) VALUES ('2', '拜仁VS尤文', '2017-10-1 19:00:00', '欧冠');
INSERT INTO `online`.`foot_site` (`id`, `name`, `start_time`, `match_name`) VALUES ('3', '曼城VS曼联', '2017-10-1 20:00:00', '英超');
INSERT INTO `online`.`foot_site` (`id`, `name`, `start_time`, `match_name`) VALUES ('4', '热刺VS大巴黎', '2017-10-1 21:00:00', '欧冠');


INSERT INTO `online`.`user_plan` (`id`, `user_id`, `site_id`, `say_info`, `foot_result`, `hot`, `click`, `create_time`) VALUES ('1', '1', '1', '皇马必胜！！！皇马必胜！！！皇马必胜！！！皇马必胜！！！皇马必胜！！！', 'WIN', '0', '0', '2017-10-01 12:00:00');
INSERT INTO `online`.`user_plan` (`id`, `user_id`, `site_id`, `say_info`, `foot_result`, `hot`, `click`, `create_time`) VALUES ('2', '2', '1', '巴萨必胜！！！巴萨必胜！！！巴萨必胜！！！巴萨必胜！！！巴萨必胜！！！巴萨必胜！！！', 'LOSS', '0', '0', '2017-10-01 12:00:00');
INSERT INTO `online`.`user_plan` (`id`, `user_id`, `site_id`, `say_info`, `foot_result`, `hot`, `click`, `create_time`) VALUES ('3', '3', '2', '应该是主。。', 'WIN', '0', '0', '2017-10-01 12:00:00');
INSERT INTO `online`.`user_plan` (`id`, `user_id`, `site_id`, `say_info`, `foot_result`, `hot`, `click`, `create_time`) VALUES ('4', '1', '3', '平手拉', 'GIVE_LOSS', '0', '0', '2017-10-01 12:00:00');
