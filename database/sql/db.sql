CREATE TABLE IF NOT EXISTS public.users
(
    id_user bigserial NOT NULL,
    surname text NOT NULL,
    name text NOT NULL,
    middlename text,
    datebirth timestamp with time zone NOT NULL,
    email text NOT NULL UNIQUE,
    phone text NOT NULL UNIQUE,
    login text NOT NULL UNIQUE,
    password text NOT NULL,
    date_reg timestamp with time zone NOT NULL,
    adress text NOT NULL,
    PRIMARY KEY (id_user),
    UNIQUE (id_user)
        INCLUDE(id_user)
);

CREATE TABLE IF NOT EXISTS public.role
(
    id_role bigserial NOT NULL UNIQUE,
    name text NOT NULL UNIQUE,
    PRIMARY KEY (id_role)
);

CREATE TABLE IF NOT EXISTS public.user_role
(
    id_user bigint NOT NULL,
    id_role bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.books
(
    id_book bigserial NOT NULL UNIQUE,
    name text NOT NULL,
    id_author bigint NOT NULL,
    date_publishing timestamp with time zone NOT NULL,
    date_entrance timestamp with time zone NOT NULL,
    date_cancellation timestamp with time zone,
    cost integer NOT NULL,
    id_publisher bigint NOT NULL,
    PRIMARY KEY (id_book)
);

CREATE TABLE IF NOT EXISTS public.check_list
(
    id_check_list bigserial NOT NULL UNIQUE,
    id_book bigint NOT NULL,
    id_status integer NOT NULL,
    id_sub bigint NOT NULL,
    date_add timestamp with time zone NOT NULL,
    date_pass integer NOT NULL,
    deadline timestamp with time zone NOT NULL,
    comment text NOT NULL,
    PRIMARY KEY (id_check_list)
);

CREATE TABLE IF NOT EXISTS public.status
(
    id_status bigserial NOT NULL UNIQUE,
    name text NOT NULL UNIQUE,
    PRIMARY KEY (id_status)
);

CREATE TABLE IF NOT EXISTS public.subscriptions
(
    id_sub bigserial NOT NULL UNIQUE,
    id_user bigint NOT NULL,
    number_ticket text NOT NULL UNIQUE,
    date_sub timestamp with time zone NOT NULL,
    date_end timestamp with time zone NOT NULL,
    PRIMARY KEY (id_sub)
);

CREATE TABLE IF NOT EXISTS public.authors
(
    id_author bigserial NOT NULL UNIQUE,
    surname text NOT NULL,
    name text NOT NULL,
    middlename text,
    datebirth timestamp with time zone NOT NULL,
    datedie time with time zone,
    country text NOT NULL,
    PRIMARY KEY (id_author)
);

CREATE TABLE IF NOT EXISTS public.log_list
(
    id_log bigserial NOT NULL UNIQUE,
    error text NOT NULL,
    time_add timestamp with time zone NOT NULL,
    PRIMARY KEY (id_log)
);

CREATE TABLE IF NOT EXISTS public.publisher
(
    id_publisher bigserial NOT NULL UNIQUE,
    name text NOT NULL,
    city text NOT NULL,
    license text NOT NULL,
    PRIMARY KEY (id_publisher)
);

ALTER TABLE IF EXISTS public.user_role
    ADD FOREIGN KEY (id_user)
        REFERENCES public.users (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public.user_role
    ADD FOREIGN KEY (id_role)
        REFERENCES public.role (id_role) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public.books
    ADD FOREIGN KEY (id_author)
        REFERENCES public.authors (id_author) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public.books
    ADD FOREIGN KEY (id_publisher)
        REFERENCES public.publisher (id_publisher) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public.check_list
    ADD FOREIGN KEY (id_book)
        REFERENCES public.books (id_book) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public.check_list
    ADD FOREIGN KEY (id_status)
        REFERENCES public.status (id_status) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public.check_list
    ADD FOREIGN KEY (id_sub)
        REFERENCES public.subscriptions (id_sub) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public.subscriptions
    ADD FOREIGN KEY (id_user)
        REFERENCES public.users (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;