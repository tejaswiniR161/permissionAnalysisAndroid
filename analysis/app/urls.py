from django.urls import path

from . import views

urlpatterns = [
    path("ui",views.uiInfo, name="ui"),
    path("select",views.select,name="select"),
    path("save",views.saveName,name="save"),
    path('', views.index, name='index'),
]