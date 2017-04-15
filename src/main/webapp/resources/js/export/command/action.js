var exportCommandAction = new function() {
    this.delete = function (id) {
        bootbox.confirm("Вы действительно хотите удалить команду?", function(confirmed) {
            if (confirmed) {
                $.ajax({
                    url: '/export/command/delete',
                    type: "POST",
                    data: { 'id': id},
                    dataType: "json",
                    success:function(data){
                        if (data.result == "true") {
                            $("#exportCommand_"+id).hide();
                            $.jGrowl('Команда удалена успешно ',{ sticky: true, theme: 'growl-error', header: 'Команда удалена' });
                        } else if (data.result == "false") {
                            $.jGrowl('Команду нельзя удалить: ' + data.error, { sticky: true, theme: 'growl-error', header: 'Удаление запрещено!' });
                        }
                    }
                });
            }
        });
        return false;
    };
    this.parse = function (id) {
        $.ajax({
            url: '/export/command/parse',
            type: "POST",
            data: { 'id': id},
            dataType: "json",
            success:function(data){
                if (data.result == "true") {
                    $.jGrowl('Команда запущена',{ sticky: true, theme: 'growl-error', header: 'Команда запущена' });
                } else if (data.result == "false") {
                    $.jGrowl('Команду нельзя запустить: ' + data.error, { sticky: true, theme: 'growl-error', header: 'Запуск запрещен!' });
                }
            }
        });
        return false;
    };

}
